package org.springframework.social.showcase;

import java.io.Serializable;


//@Component
//@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SessionRealtor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String realtorId;
	
	public SessionRealtor(String realtorId){
		this.realtorId = realtorId;
	}
	
	public SessionRealtor(){
	}
	

	public String getRealtorId() {
		return realtorId;
	}

	public void setRealtorId(String realtorId) {
		this.realtorId = realtorId;
	}
	
}
