package com.devoops.component;

import org.springframework.stereotype.Component;

import session.LoginSession;

@Component
public class BaseComponent {
	
	public final static String LOGIN_SESSION = "loginSession";
	
	protected LoginSession loginSession;
	
	
	public BaseComponent() {
		
	}
}
