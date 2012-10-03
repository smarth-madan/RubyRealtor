package org.springframework.social.showcase.mlsListing.model;

public class Property {

	private String MLS_ID;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String rating;
	private String image;
	private String bed_bath;
	private String size;
	private String price;
	private String type;
	private String parking;
	private String garage;
	
	public String getBed_bath() {
		return bed_bath;
	}
	public void setBed_bath(String bed_bath) {
		this.bed_bath = bed_bath;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getGarage() {
		return garage;
	}
	public void setGarage(String garage) {
		this.garage = garage;
	}
	public String getRating() {
		return rating;
	}
	public String getMLS_ID() {
		return MLS_ID;
	}
	public void setMLS_ID(String mLS_ID) {
		MLS_ID = mLS_ID;
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
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
