package com.devoops.service.email;

import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailAuthSendServiceImpl implements EmailAuthSendService {
	
	@Autowired
    public JavaMailSender mailSender;
	
	@Override
	public int sendSimpleMessage(String to) {
		int ran = new Random().nextInt(900000) + 100000;
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			
			message.addRecipient(RecipientType.TO, new InternetAddress("zinzoddari@gmail.com"));
	        message.setSubject("[devOops] 회원가입을 위한 인증번호");

	        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
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
	        sb.append("								<strong>" + ran + "</strong>");
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
	        		 	
	        helper.setText(sb.toString(), true);
	        helper.setTo(to);
	        helper.setFrom("zinzoddari@gmail.com");	//수정필요

	        mailSender.send(message);
		}
		catch (Exception e) {
			e.printStackTrace();
			
			return 0;
		}
		
		return 1;
	}
}
