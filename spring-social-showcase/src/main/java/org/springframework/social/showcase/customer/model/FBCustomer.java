package org.springframework.social.showcase.customer.model;

public class FBCustomer {



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
	public String getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(String numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	String phone_number;
	String R_ID;
	String CR_ID;
	String customer_priority;
	String appointment;
	String type_house;
	String type_apartment;
	String type_studio;	
	String type_any;
	String bedRoomNumber1;
	String bedRoomNumber2;
	String bedRoomNumber3;
	String numberOfPersons;
	String bathNumber1;
	String bathNumber2;
	String bathNumber3;
	String house_city;
	String house_state;
	String location_downtown;
	String location_suburb;
	String range_lt_100k;
	String range_100k_400k;
	String range_gt_400k;
	String range_any;
	String range;
	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	String homeDescription;
	
	
	public String getHomeDescription() {
		return homeDescription;
	}

	public void setHomeDescription(String homeDescription) {
		this.homeDescription = homeDescription;
	}

	public String getType_any() {
		return type_any;
	}

	public void setType_any(String type_any) {
		this.type_any = type_any;
	}

	String number_of_persons;
	public String getNumber_of_persons() {
		return number_of_persons;
	}

	public void setNumber_of_persons(String number_of_persons) {
		this.number_of_persons = number_of_persons;
	}


	//Timestamp time;
	
	public String getRange_any() {
		return range_any;
	}

	public void setRange_any(String range_any) {
		this.range_any = range_any;
	}

	public String getBedRoomNumber1() {
		return bedRoomNumber1;
	}

	public void setBedRoomNumber1(String bedRoomNumber1) {
		this.bedRoomNumber1 = bedRoomNumber1;
	}

	public String getBedRoomNumber2() {
		return bedRoomNumber2;
	}

	public void setBedRoomNumber2(String bedRoomNumber2) {
		this.bedRoomNumber2 = bedRoomNumber2;
	}

	public String getBedRoomNumber3() {
		return bedRoomNumber3;
	}

	public void setBedRoomNumber3(String bedRoomNumber3) {
		this.bedRoomNumber3 = bedRoomNumber3;
	}

	public String getBathNumber1() {
		return bathNumber1;
	}

	public void setBathNumber1(String bathNumber1) {
		this.bathNumber1 = bathNumber1;
	}

	public String getBathNumber2() {
		return bathNumber2;
	}

	public void setBathNumber2(String bathNumber2) {
		this.bathNumber2 = bathNumber2;
	}

	public String getBathNumber3() {
		return bathNumber3;
	}

	public void setBathNumber3(String bathNumber3) {
		this.bathNumber3 = bathNumber3;
	}

	public String getHouse_city() {
		return house_city;
	}

	public void setHouse_city(String house_city) {
		this.house_city = house_city;
	}

	public String getHouse_state() {
		return house_state;
	}

	public void setHouse_state(String house_state) {
		this.house_state = house_state;
	}

	public String getLocation_downtown() {
		return location_downtown;
	}

	public void setLocation_downtown(String location_downtown) {
		this.location_downtown = location_downtown;
	}

	public String getLocation_suburb() {
		return location_suburb;
	}

	public void setLocation_suburb(String location_suburb) {
		this.location_suburb = location_suburb;
	}

	public String getRange_lt_100k() {
		return range_lt_100k;
	}

	public void setRange_lt_100k(String range_lt_100k) {
		this.range_lt_100k = range_lt_100k;
	}

	public String getRange_100k_400k() {
		return range_100k_400k;
	}

	public void setRange_100k_400k(String range_100k_400k) {
		this.range_100k_400k = range_100k_400k;
	}

	public String getRange_gt_400k() {
		return range_gt_400k;
	}

	public void setRange_gt_400k(String range_gt_400k) {
		this.range_gt_400k = range_gt_400k;
	}

	public String getType_house() {
		return type_house;
	}

	public void setType_house(String type_house) {
		this.type_house = type_house;
	}

	public String getType_apartment() {
		return type_apartment;
	}

	public void setType_apartment(String type_apartment) {
		this.type_apartment = type_apartment;
	}

	public String getType_studio() {
		return type_studio;
	}

	public void setType_studio(String type_studio) {
		this.type_studio = type_studio;
	}

	
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
