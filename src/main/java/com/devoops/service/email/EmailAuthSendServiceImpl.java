package com.devoops.service.email;

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
	public int sendMessage(String subject, String to, String text) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);

	        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
	        		 	
	        helper.setText(text, true);
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
