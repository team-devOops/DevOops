/* * * * * * * * * * * * * * * * * * * * * * * * * * * * 
*      FILE NAME : LoginSession.java
* REPORTING DATE : 2020.01.06
*     WRITTEN BY : zinzoddari@gmail.com
=====================================================
* REVISION HISTORY
* * * * * * * * * * * * * * * * * * * * * * * * * * * */

package common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionCommon{
	
	/**
	 * 임시 세션 저장
	 * @author zinzo
	 */
	@SuppressWarnings("null")
	public static void setTempSession(String key, Object value) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		HttpSession session = null;
		
		if(session.getAttribute(key) == null) {
			session = request.getSession(true);
			
			session.setAttribute(key, value);
		}
	}
	
	/**
	 * 임시 세션 삭제
	 * @author zinzo
	 */
	@SuppressWarnings("null")
	public static void popTempSession(String key) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		
		HttpSession session = null;
		
		if(session.getAttribute(key) != null) {
			session = request.getSession();
			
			session.removeAttribute(key);
		}
	}
}
