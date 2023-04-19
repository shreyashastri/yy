package com.emp.api.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

 @Entity
 @Table (name="employ")
 @SQLDelete(sql = "UPDATE employ SET flag = true WHERE id=?")   //SOFT DELETE 
 @Where(clause = "flag=false") // DOES NOT INCLUDE THE COLUMN WHILE DISPLAYING 
 
 public class Entty {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	 @Column(name="first_Name",nullable=false)  
	 private String firstName;
	
	 @Column(name="last_Name",nullable=false)
	 private String lastName;
	
	 @Column(name="email",nullable=false)
	  private String email;
	 
	 @Column(name="age",nullable=false)
	 private int age;
	 
	 @Column(name="phno",nullable=false)
	 private String phno;
	 
	 @Column(name="user_Name",nullable=false)
	 private String userName;

	 @Column(name="flag",nullable=false)
	 private boolean flag = Boolean.FALSE;

	 @Column(name="response_Json",nullable=false)
	 private String details; 
	 
  
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

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	
	}


	

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
