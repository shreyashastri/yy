package com.emp.api.dto;

public class PojoAddressUpdate {
	
	 private int id; 
	 private String city;
	 private String country;
	 private String state;
	 private String postalCode;
	 private int empid ;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public String setCity(String city) {
		return this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String setPostalCode(String postalCode) {
		return this.postalCode = postalCode;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	 
}
