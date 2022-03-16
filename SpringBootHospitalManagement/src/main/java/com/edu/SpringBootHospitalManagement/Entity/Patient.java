package com.edu.SpringBootHospitalManagement.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity(name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private long patientId;
	
	@Column(name = "patient_first_name")
	private String patientFirstName;
	
	@Column(name = "patient_last_name")
	private String patientLastName;
	
	@Column
	private int age;
	
	@Column
	private String gender;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "contact_no")
	private String contactNo;
	
	@Column(name = "alternative_no")
	private String alternativeNo;
	
	@OneToOne
	@JoinColumn(name = "address")
	private PatientAddress address;
	
	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public PatientAddress getAddress() {
		return address;
	}

	public void setAddress(PatientAddress address) {
		this.address = address;
	}

	
	
	
}
