package com.devoops.service.email;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailAuthSendServiceImpl implements EmailAuthSendService {
	
	@Autowired
    public JavaMailSender emailSender;
	
	@Override
	public int sendSimpleMessage(String to) {
		int ran = new Random().nextInt(900000) + 100000;
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject("인증코드 테스트");
	        String text = "귀하의 인증 코드는 " + ran + "입니다.";
	        message.setText(text);
	        emailSender.send(message);
		}
		catch (Exception e) {
			e.printStackTrace();
			
			return 0;
		}
		return 1;
	}
}
