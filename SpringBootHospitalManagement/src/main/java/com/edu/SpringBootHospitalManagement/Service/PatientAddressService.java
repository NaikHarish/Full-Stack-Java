package com.edu.SpringBootHospitalManagement.Service;

import java.util.List;

import com.edu.SpringBootHospitalManagement.Entity.PatientAddress;

public interface PatientAddressService {

	List<PatientAddress> getAllPatientAddresses();

	PatientAddress addPatientAddress(PatientAddress patientAddress);

	PatientAddress getPatientAddressById(long id);

	PatientAddress updatePatientAddress(PatientAddress patientAddress, long id);

}
