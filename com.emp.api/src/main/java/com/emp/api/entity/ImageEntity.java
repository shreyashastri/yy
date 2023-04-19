package com.emp.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="emp_image")
public class ImageEntity {
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)

       @Column(name="img_id")
	    private Long imgId;
 
       @Column(name="name")
	    private String name;
     
       @Column(name="type")
	    private String type;
       
       @Column(name="emp_id")
	    private int empId;

     @Lob
    @Column(name="image")
	 private byte[] image;

     
	public Long getImgId() {
		return imgId;
	}

	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

    public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

    }
