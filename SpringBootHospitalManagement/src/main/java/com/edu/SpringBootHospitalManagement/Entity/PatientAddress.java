package com.edu.SpringBootHospitalManagement.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "patient_address")
public class PatientAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long addId;
	
	@Column
	private String houseNo;
	
	@Column
	private String wardNo;
	
	@Column
	private String city;
	
	@Column
	private String dist;
	
	@Column
	private int pinCode;
	
	@JsonBackReference
	@OneToOne(mappedBy = "address")
	private Patient patient;
	

	public PatientAddress() {
		super();
		
	}

	public PatientAddress(long addId, String houseNo, String city, String dist, int pinCode) {
		super();
		this.addId = addId;
		this.houseNo = houseNo;
		this.city = city;
		this.dist = dist;
		this.pinCode = pinCode;
	}

	public long getAddId() {
		return addId;
	}

	public void setAddId(long addId) {
		this.addId = addId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getWardNo() {
		return wardNo;
	}

	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}