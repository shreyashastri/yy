package com.emp.api.dto;

import java.util.Map;

public class EmpImgResponse {
	
	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private String phno;
	private String email;
	private String userName;
	private Map<String,Object>imadegata;
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Map<String, Object> getImadegata() {
		return imadegata;
	}
	public void setImadegata(Map<String, Object> imadegata) {
		this.imadegata = imadegata;
	}
	
	
     }
