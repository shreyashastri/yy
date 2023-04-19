package com.emp.api.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class AddressEntity {

	
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id",nullable=false)
		private int id; 
	    
		@Column(name="postal_Code",nullable=false)
	    private String postalCode;
		 
		@Column(name="city",nullable=false)
		private String city;
		
		@Column(name="state",nullable=false)
	    private String state ; 
		
		@Column(name="country",nullable=false)
		private String country; 

		@Column(name="empid")
         private int empId;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
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

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		
				
		}
	

