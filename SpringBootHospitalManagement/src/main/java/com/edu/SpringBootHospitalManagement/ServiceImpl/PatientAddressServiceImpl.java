package com.edu.SpringBootHospitalManagement.ServiceImpl;

import java.util.List;
import java.util.Optional;

import com.edu.SpringBootHospitalManagement.Entity.PatientAddress;
import com.edu.SpringBootHospitalManagement.Exception.ResourceNotFound;
import com.edu.SpringBootHospitalManagement.Repository.PatientAddressRepository;
import com.edu.SpringBootHospitalManagement.Service.PatientAddressService;

public class PatientAddressServiceImpl implements PatientAddressService{
	
private PatientAddressRepository patientAddressRepository;
	
	
	public PatientAddressServiceImpl(PatientAddressRepository patientAddressRepository) {
		super();
		this.patientAddressRepository = patientAddressRepository;
	}


	@Override
	public PatientAddress addPatientAddress(PatientAddress patientAddress) {
		return patientAddressRepository.save(patientAddress);
	}


	@Override
	public List<PatientAddress> getAllPatientAddresses() {
		return patientAddressRepository.findAll();
	}


	@Override
	public PatientAddress getPatientAddressById(long id) {
		Optional<PatientAddress> patientAddress = patientAddressRepository.findById(id);
		if (patientAddress.isPresent()) {
			return patientAddress.get();
		} else {
			throw new ResourceNotFound("PatientAddress", "Id", id);
		}
	}


	@Override
	public PatientAddress updatePatientAddress(PatientAddress patientAddress, long id) {
		PatientAddress patientAddress2 = new PatientAddress();
		
		try {
			patientAddress2 = patientAddressRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFound("PatientAddress", "Id", id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		patientAddress2.setHouseNo(patientAddress.getHouseNo());
		patientAddress2.setWardNo(patientAddress.getWardNo());
		patientAddress2.setCity(patientAddress.getCity());
		patientAddress2.setDist(patientAddress.getDist());
		patientAddress2.setPinCode(patientAddress.getPinCode());
		
		return patientAddressRepository.save(patientAddress2);
	}
}
