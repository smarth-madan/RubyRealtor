package org.springframework.social.showcase.customer.model;

public class CRequirements {
	String cr_ID;
	Integer noOfPersons;
	Integer noOfBedrooms;
	String city;
	String state;
	String zipcode;
	String rangeAmount;
	String type;
	
	public String getCr_ID() {
		return cr_ID;
	}
	public void setCr_ID(String cr_ID) {
		this.cr_ID = cr_ID;
	}
	public Integer getNoOfPersons() {
		return noOfPersons;
	}
	public void setNoOfPersons(Integer noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	public Integer getNoOfBedrooms() {
		return noOfBedrooms;
	}
	public void setNoOfBedrooms(Integer noOfBedrooms) {
		this.noOfBedrooms = noOfBedrooms;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getRangeAmount() {
		return rangeAmount;
	}
	public void setRangeAmount(String rangeAmount) {
		this.rangeAmount = rangeAmount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
