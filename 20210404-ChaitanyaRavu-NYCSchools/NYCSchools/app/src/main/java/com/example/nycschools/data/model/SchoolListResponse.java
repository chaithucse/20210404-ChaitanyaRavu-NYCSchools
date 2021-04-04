package com.example.nycschools.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SchoolListResponse implements Serializable {
	@SerializedName("longitude")
	private String longitude;
	@SerializedName("zip")
	private String zip;
	@SerializedName("fax_number")
	private String faxNumber;
	@SerializedName("dbn")
	private String dbn;
	@SerializedName("phone_number")
	private String phoneNumber;

	@Override
	public String toString() {
		return "SchoolListResponse{" +
				"longitude='" + longitude + '\'' +
				", zip='" + zip + '\'' +
				", faxNumber='" + faxNumber + '\'' +
				", dbn='" + dbn + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", city='" + city + '\'' +
				", website='" + website + '\'' +
				", schoolName='" + schoolName + '\'' +
				", primaryAddressLine1='" + primaryAddressLine1 + '\'' +
				", schoolEmail='" + schoolEmail + '\'' +
				", location='" + location + '\'' +
				'}';
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getDbn() {
		return dbn;
	}

	public void setDbn(String dbn) {
		this.dbn = dbn;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getPrimaryAddressLine1() {
		return primaryAddressLine1;
	}

	public void setPrimaryAddressLine1(String primaryAddressLine1) {
		this.primaryAddressLine1 = primaryAddressLine1;
	}

	public String getSchoolEmail() {
		return schoolEmail;
	}

	public void setSchoolEmail(String schoolEmail) {
		this.schoolEmail = schoolEmail;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@SerializedName("city")
	private String city;
	@SerializedName("website")
	private String website;
	@SerializedName("school_name")
	private String schoolName;
	@SerializedName("primary_address_line_1")
	private String primaryAddressLine1;
	@SerializedName("school_email")
	private String schoolEmail;
	@SerializedName("location")
	private String location;

}

