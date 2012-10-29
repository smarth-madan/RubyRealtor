package org.springframework.social.showcase.mlsListing.model;

public class Property {

	private String MLS_ID;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String imageName;
	private String image;
	private String bed_bath;
	private String size;
	private String price;
	private String type;
	private String parking;
	private String garage;
	private String tags;
	private String description;
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
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
	public String getImage() {
		return image;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
