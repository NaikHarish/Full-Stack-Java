package com.edu.SpringBootHospitalManagement.Service;

import java.util.List;

import com.edu.SpringBootHospitalManagement.Entity.Patient;

public interface PatientService {

	List<Patient> getAllPatients();

	Patient savePatient(Patient patient);

	Patient getPatientById(long id);

	Patient updatePatient(Patient patient, long id);

	void deletePatient(long id);

}
