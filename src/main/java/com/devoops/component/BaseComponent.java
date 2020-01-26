package com.devoops.component;

import org.springframework.stereotype.Component;

import session.LoginSession;

import java.util.HashMap;
import java.util.Map;

@Component
public class BaseComponent {
	
	public final static String LOGIN_SESSION = "loginSession";
	
	protected LoginSession loginSession;

	public BaseComponent() {
		this.loginSession = new LoginSession();


	}


}
