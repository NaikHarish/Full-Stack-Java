package com.edu.SpringBootHospitalManagement.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBootHospitalManagement.Entity.Patient;
import com.edu.SpringBootHospitalManagement.Exception.ResourceNotFound;
import com.edu.SpringBootHospitalManagement.Repository.PatientRepository;
import com.edu.SpringBootHospitalManagement.Service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	private PatientRepository patientRepository;

	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	@Override
	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientById(long id) {
		Optional<Patient> patient = patientRepository.findById(id);
		if (patient.isPresent()) {
			return patient.get();
		} else {
			throw new ResourceNotFound("Patient", "id", id);
		}
	}

	@Override
	public Patient updatePatient(Patient patient, long id) {
		Patient pat = new Patient();

		try {
			pat = patientRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Patient", "Id", id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		pat.setPatientFirstName(patient.getPatientFirstName());
		pat.setPatientLastName(patient.getPatientLastName());
		pat.setAge(patient.getAge());
		pat.setGender(patient.getGender());
		pat.setEmailId(patient.getEmailId());
		pat.setContactNo(patient.getContactNo());
		pat.setAlternativeNo(patient.getAlternativeNo());
		pat.setAddress(patient.getAddress());

		return patientRepository.save(pat);
	}

	@Override
	public void deletePatient(long id) {
		patientRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Patient", "Id", id));

		patientRepository.deleteById(id);

	}
}
