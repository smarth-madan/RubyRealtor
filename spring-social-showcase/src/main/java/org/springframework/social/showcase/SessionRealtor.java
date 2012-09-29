package org.springframework.social.showcase;


//@Component
//@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SessionRealtor {

	private int realtorId;
	
	public SessionRealtor(int realtorId){
		this.realtorId = realtorId;
	}
	
	public SessionRealtor(){
	}
	

	public int getRealtorId() {
		return realtorId;
	}

	public void setRealtorId(int realtorId) {
		this.realtorId = realtorId;
	}
	
}
