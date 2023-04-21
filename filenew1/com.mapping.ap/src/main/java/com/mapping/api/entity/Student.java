package com.mapping.api.entity;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usn")
	private int usn;
	
	@Column(name="name")
	private String name;
	
	@Column(name="branch")
    private String branch; 
	
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "student_usn", referencedColumnName = "usn")
	 List<Subject>subject = new ArrayList<>();

	
    public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	public Student(String name, String branch) {
		super();
		this.name = name;
		this.branch = branch;
	}

	public int getUsn() {
		return usn;
	}

	public void setUsn(int usn) {
		this.usn = usn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	
	
	
	}
