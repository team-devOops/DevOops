/* * * * * * * * * * * * * * * * * * * * * * * * * * * * 
*      FILE NAME : SignUpController.java
* REPORTING DATE : 2020.01.10
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
* * * * * * * * * * * * * * * * * * * * * * * * * * * */

package com.devoops.controller.auth;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devoops.component.BaseComponent;
import com.devoops.domain.CustUser;
import com.devoops.service.custuser.CustUserService;
import com.devoops.service.email.EmailAuthSendService;

import lombok.extern.slf4j.Slf4j;
import session.AnonymSession;
import utils.CryptUtils;
import utils.DateUtils;

@RestController
@Slf4j
public class SignUpController extends BaseComponent {
	
	@Autowired
	CustUserService custUserService;
	
	@Autowired
	EmailAuthSendService emailAuthSendService;
	
	@PostMapping(value = "/auth/checkDupliEmail")
	public boolean checkDupliEmail(@RequestBody CustUser reqCustUser) {
		
		CustUser custUser = custUserService.searchCustUSer(reqCustUser.getUserId());
		
		if(log.isDebugEnabled()) {
			log.debug("custUser : " + (custUser == null ? true : false));
		}
		
		return custUser == null ? true : false;
	}
	
	@PostMapping(value = "/auth/sendAuthEmail")
	public int sendAuthEmail(@RequestBody CustUser reqCustUser) {
		int randomAuthCd = new Random().nextInt(900000) + 100000;
		
		String subject = "[devOops] 회원가입을 위한 인증번호";
		
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<body>");
        sb.append("		<table width='100%'>");
        sb.append("			<tr>");
        sb.append("				<td width='20%'></td>");
        sb.append("				<td width='60%'>");
        sb.append("					<table width='100%'>");
        sb.append("						<tr height='300'>");
        sb.append("							<td colspan=3 style='padding:20px; height: 50%; font-size: 17pt; background: linear-gradient(to right, #ff6699, #6699ff); color: white;'>");
        sb.append("								<strong>devOops</strong>");
        sb.append("							</td>");
        sb.append("						</tr>");
        sb.append("						<tr><td colspan='3' height='18'></td></tr>");
        sb.append("						<tr>");
        sb.append("							<td width='6%'></td>");
        sb.append("							<td width='88%' style='font-size: 20pt;'>");
        sb.append("								devOops에서 회원가입 인증번호를<br />");
        sb.append("								발송해 드립니다.");
        sb.append("							</td>");
        sb.append("							<td width='6%'></td>");
        sb.append("						</tr>");
        sb.append("						<tr><td colspan='3' height='18'></td></tr>");
        sb.append("						<tr>");
        sb.append("							<td width='6%' height='1'></td>");
        sb.append("							<td width='88%' height='1' bgcolor='#d8dad8'></td>");
        sb.append("							<td width='6%' height='1'></td>");
        sb.append("						</tr>");
        sb.append("						<tr>");
        sb.append("							<td colspan='3' style='text-align: center; font-size: 28pt; letter-spacing: 5px;'>");
        sb.append("								<strong>" + randomAuthCd + "</strong>");
        sb.append("							</td>");
        sb.append("						</tr>");
        sb.append("						<tr>");
        sb.append("							<td width='6%' height='1'></td>");
        sb.append("							<td width='88%' height='1' bgcolor='#d8dad8'></td>");
        sb.append("							<td width='6%' height='1'></td>");
        sb.append("						</tr>");
        sb.append("						<tr><td colspan='3' height='18'></td></tr>");
        sb.append("						<tr>");
        sb.append("							<td width='6%'></td>");
        sb.append("							<td width='88%' style='font-size: 12pt;'>");
        sb.append("								해당 번호 6자리를 인증번호 입력란에 입력해 주세요.");
        sb.append("							</td>");
        sb.append("							<td width='6%'></td>");
        sb.append("						</tr>");
        sb.append("						<tr><td colspan='3' height='18'></td></tr>");
        sb.append("						<tr>");
        sb.append("							<td colspan='3'></td>");
        sb.append("						</tr>");
        sb.append("						<tr>");
        sb.append("							<td colspan='3' style='padding:20px; font-size: 8pt; background-color:#d8dad8;'>");
        sb.append("								본 메일은 발신 전용 입니다.<br />");
        sb.append("								Copyright 2020. devOops. All rights reserved.");
        sb.append("							</td>");
        sb.append("						</tr>");
        sb.append("					</table>");
        sb.append("				</td>");
        sb.append("				<td width='20%'></td>");
        sb.append("			</tr>");
        sb.append("		</table>");
        sb.append("</body>");
        sb.append("</html>");
        
		int result = emailAuthSendService.sendMessage(subject, reqCustUser.getUserId(), sb.toString());
		
		AnonymSession.getAnonymSession().setTempSession("__SIGN_UP_RANDOM_AUTH_CD__", randomAuthCd);
		
		return result;
	}
	
	@PostMapping(value = "/auth/checkAuthEmail")
	public int checkAuthEmail(@RequestParam int emailAuthCd) {
		
		System.out.println("@@@@@@emailAuthCd : " + emailAuthCd);
		
		return 0;
	}
	
	@PostMapping(value = "/auth/signUp")
	public CustUser postSignUp(@RequestBody CustUser custUser) {
		
		custUser.setUserPw(CryptUtils.hashSHA256(custUser.getUserPw()));
		//custUser.setEmailAuthYn("N");
		custUser.setUseYn("Y");
		custUser.setRegUserId(custUser.getUserId());
		custUser.setRegDt(DateUtils.getTimeStamp());

		custUserService.userSave(custUser);
		
		if(log.isDebugEnabled()) {
			log.debug("custUser : " + custUser);
		}
		
		return custUser;
	}
	
}
