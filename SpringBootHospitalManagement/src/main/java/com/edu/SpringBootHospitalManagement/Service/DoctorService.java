package com.edu.SpringBootHospitalManagement.Service;

import java.util.List;

import com.edu.SpringBootHospitalManagement.Entity.Doctor;

public interface DoctorService {

	Doctor saveDoctor(Doctor doctor);
	
	List<Doctor> getAllDoctor();
	
	Doctor getDoctorById(long id);
	
	List<Doctor> getDoctorByDocFirstName(String docFirstName);

	List<Doctor> getDoctorByDocLastName(String docLastName);

	List<Doctor> getDoctorByDocFirstNameAndDocLastName(String docFirstName, String docLastName);

	Doctor getDoctorFullNameByDocId(long docId);

	List<Doctor> getDoctorInDescOrder();

	int getDoctorCount();

	Doctor updateDoctor(Doctor doctor, long id);

	Doctor patchDoctor(Doctor doctor, long id);

	void deleteDoctor(long id);


	

	

}
