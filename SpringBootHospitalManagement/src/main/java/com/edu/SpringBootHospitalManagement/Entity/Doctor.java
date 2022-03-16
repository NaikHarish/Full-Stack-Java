package com.edu.SpringBootHospitalManagement.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;

@Data
@Entity(name = "doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long docId;
	
	@Column(name = "doc_First_Name")
	private String docFirstName;

	@Column(name = "doc_Last_Name")
	private String docLastName;
	
	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	@Column(name = "room_no")
	private int roomNo;

	@Column(name = "specialization")
	private String specialization;

	@Column(name = "contact_no")
	private String contactNo;

	@Column(name = "alternative_no")
	private String alternativeNo;

	@Column(name = "location")
	private String location;
	
	@ManyToOne
	@JoinColumn(name = "department")
	private Department department;

	public long getDocId() {
		return docId;
	}

	public void setDocId(long docId) {
		this.docId = docId;
	}

	public String getDocFirstName() {
		return docFirstName;
	}

	public void setDocFirstName(String docFirstName) {
		this.docFirstName = docFirstName;
	}

	public String getDocLastName() {
		return docLastName;
	}

	public void setDocLastName(String docLastName) {
		this.docLastName = docLastName;
	}


	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAlternativeNo() {
		return alternativeNo;
	}

	public void setAlternativeNo(String alternativeNo) {
		this.alternativeNo = alternativeNo;
	}

	public String getLocation() {
		return location;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
