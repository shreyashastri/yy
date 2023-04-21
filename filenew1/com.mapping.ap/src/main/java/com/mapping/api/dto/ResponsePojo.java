package com.mapping.api.dto;

import java.util.List;

public class ResponsePojo {
	
	private int usn; 
	private String name; 
	private String branch;
	
	List<SubjectPojo>subjectPojo;

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

	public List<SubjectPojo> getSubjectPojo() {
		return subjectPojo;
	}

	public void setSubjectPojo(List<SubjectPojo> subjectPojo) {
		this.subjectPojo = subjectPojo;
	}

    }
