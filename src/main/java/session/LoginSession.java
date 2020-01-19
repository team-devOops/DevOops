package session;

import com.devoops.component.BaseComponent;
import com.devoops.mgr.AbstractLoginSession;
import com.devoops.mgr.CustInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginSession extends AbstractLoginSession implements com.devoops.mgr.LoginSession {
	
	private CustInfo custInfo;
	
	public CustInfo getCustInfo() {
		return this.custInfo;
	}
	
	public void setCustInfo(CustInfo custInfo) {
		setSession(BaseComponent.LOGIN_SESSION, custInfo);
		
		this.custInfo = custInfo;
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@^_^");
		
		if(log.isDebugEnabled()) {
			log.debug("GENERATE LOGIN SESSION : " + this.custInfo);
		}
	}
}
