package com.devoops.mgr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public abstract class AbstractLoginSession implements LoginSession {
	
	protected CustInfo custInfo;
	
	
	public AbstractLoginSession() {
		
	}
	
	public CustInfo getCustInfo() {
		return this.custInfo;
	}
	
	public String getUserId() {
		return this.custInfo.getUserId();
	}
	
	public String getName() {
		return this.custInfo.getName();
	}
	
	public String getEmail() {
		return this.custInfo.getEmail();
	}
	
	/**********************************/
	/**
	 * 임시 세션 저장
	 * @author zinzo
	 */
	public static void setTempSession(String key, Object value) {
		setSession(key, value);
	}
	
	/**
	 * 임시 세션 삭제
	 * @author zinzo
	 */
	public static void popTempSession(String key) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		HttpSession session = null;

		session = request.getSession();
		
		if(session.getAttribute(key) != null) {
			session.removeAttribute(key);
		}
	}
	
	/**
	 * 도메인 세션 등록
	 * @author zinzo
	 */
	public static void setSession(String sessionName, Object object) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute(sessionName) == null) {
			session.setAttribute(sessionName, object);
		}
	}
	
	/**
	 * 도메인 세션 Get
	 * @author zinzo
	 */
	@SuppressWarnings("null")
	public static Object getSession(String sessionName) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		HttpSession session = null;
		
		if(session.getAttribute(sessionName) != null) {
			return request.getAttribute(sessionName);
		}
		return null;
	}
}
