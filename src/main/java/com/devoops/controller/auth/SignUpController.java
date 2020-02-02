/* * * * * * * * * * * * * * * * * * * * * * * * * * * * 
*      FILE NAME : SignUpController.java
* REPORTING DATE : 2020.01.10
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
* * * * * * * * * * * * * * * * * * * * * * * * * * * */

package com.devoops.controller.auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devoops.component.BaseComponent;
import com.devoops.domain.CustUser;
import com.devoops.service.custuser.CustUserService;
import com.devoops.service.email.EmailAuthSendService;

import lombok.extern.slf4j.Slf4j;
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
	public int checkDupliEmail(@RequestBody CustUser reqCustUser) {
		
		CustUser custUser = custUserService.searchCustUSer(reqCustUser.getUserId());
		
		if(log.isDebugEnabled()) {
			log.debug("custUser : " + custUser);
		}
		
		return custUser == null ? 0 : 1;
	}
	
	@PostMapping(value = "/auth/sendAuthEmail")
	public int sendAuthEmail(@RequestBody CustUser reqCustUser) {
		return emailAuthSendService.sendSimpleMessage(reqCustUser.getUserId()) == 0 ? 0 : 1;
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
