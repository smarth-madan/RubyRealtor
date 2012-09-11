package org.springframework.social.showcase.realtor.model;

public class MyProfile {
 
	private String fname;
	private String lname;
	private String address;
	private String emailId;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRealtorId() {
		return realtorId;
	}
	public void setRealtorId(String realtorId) {
		this.realtorId = realtorId;
	}
	private String realtorId;
	
	
}
