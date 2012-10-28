package org.springframework.social.showcase.customer.model;

import java.sql.Timestamp;

public class Customer {
	
    private static final long serialVersionUID = 1L;

	String c_id;
	
	String name;
	
	String street;
	
	String city;
	
	String state;
	
	String zipcode;
	
	String martial_status;
	
	String salary_min_val;
	
	String salary_max_val;

	String email_ID;
	
	String phone_number;
	
	String R_ID;
	
	String CR_ID;
	
	String customer_priority;
	
	String appointment;
	
	//Timestamp time;
	
	public String getAppointment() {
		return appointment;
	}

	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}


	/*public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}*/

	public String getCustomer_priority() {
		return customer_priority;
	}

	public void setCustomer_priority(String customer_priority) {
		this.customer_priority = customer_priority;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getMartial_status() {
		return martial_status;
	}

	public void setMartial_status(String martial_status) {
		this.martial_status = martial_status;
	}

	public String getEmail_ID() {
		return email_ID;
	}

	public void setEmail_ID(String email_ID) {
		this.email_ID = email_ID;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getR_ID() {
		return R_ID;
	}

	public void setR_ID(String r_ID) {
		R_ID = r_ID;
	}

	public String getCR_ID() {
		return CR_ID;
	}

	public String getSalary_min_val() {
		return salary_min_val;
	}

	public void setSalary_min_val(String salary_min_val) {
		this.salary_min_val = salary_min_val;
	}

	public String getSalary_max_val() {
		return salary_max_val;
	}

	public void setSalary_max_val(String salary_max_val) {
		this.salary_max_val = salary_max_val;
	}

	public void setCR_ID(String cR_ID) {
		CR_ID = cR_ID;
	}
	
	
	
	
	
}
