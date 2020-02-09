package session;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnonymSession extends LoginSession {
	private static LoginSession anonymSession = null;
	
	private AnonymSession() {
		
	}
	
	public static LoginSession getAnonymSession() {
		if(anonymSession == null) {
			anonymSession = new LoginSession();
		}
		
		return anonymSession;
	}
}
