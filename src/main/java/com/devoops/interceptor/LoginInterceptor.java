package com.devoops.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.devoops.component.BaseComponent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginInterceptor extends BaseComponent implements HandlerInterceptor{
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String reqUrl = request.getRequestURI().toString();
		System.out.println("reqUrl : " + reqUrl);
		if(loginSession == null) {
			log.info("not Login");
		}
		
		return true;
    }
	
	@Override 
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) { 
		if(log.isDebugEnabled()) {
			log.debug("loginSession : " + loginSession);
		}
	}
}
