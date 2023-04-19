package com.emp.api.dto;

public class Pojoemp {
	 
	 private int id; 
	 private String firstName;
	 private String lastName;
	 private String email;
	 private int age;
	 private String phno;
	 private String userName;
	 
     private PojoAddress address;
     
     private ResponseJson responseJson; //CHANGES MADE 
	
     
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public PojoAddress getAddress() {
		return address;
	}

	public void setAddress(PojoAddress address) {
		this.address = address;
	}

	public ResponseJson getResponseJson() {
		return responseJson;
	}

	public void setResponseJson(ResponseJson responseJson) {
		this.responseJson = responseJson;
	}

	}
