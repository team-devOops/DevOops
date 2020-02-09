package com.devoops.service.email;

public interface EmailAuthSendService {
	public int sendMessage(String subject, String to, String text);
}
