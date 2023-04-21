package com.mapping.api.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="subject")
public class Subject{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subject_Code")
    private int subjectCode;
	
	@Column(name="subject_Name")
    private String subjectName;
	
	

	public Subject(String subjectName) {
		super();
		this.subjectName = subjectName;
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public void setSubject_Code(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
 
	
	

}   
