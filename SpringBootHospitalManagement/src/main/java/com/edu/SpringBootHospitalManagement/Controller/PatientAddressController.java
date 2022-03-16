package com.edu.SpringBootHospitalManagement.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.SpringBootHospitalManagement.Entity.PatientAddress;
import com.edu.SpringBootHospitalManagement.Service.PatientAddressService;

@RestController
@RequestMapping("/api/patientAddress")
public class PatientAddressController {
	
	private PatientAddressService patientAddressService;

	public PatientAddressController(PatientAddressService patientAddressService) {
		super();
		this.patientAddressService = patientAddressService;
	}
	
	@PostMapping
	public ResponseEntity<PatientAddress> addPatientAddress(@RequestBody PatientAddress patientAddress){
		return new ResponseEntity<PatientAddress>(patientAddressService.addPatientAddress(patientAddress), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<PatientAddress> getAllPatientAddresses(){
		return patientAddressService.getAllPatientAddresses();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PatientAddress> getPatientAddressById(@PathVariable("id") long id) {
		return new ResponseEntity<PatientAddress>(patientAddressService.getPatientAddressById(id), HttpStatus.OK);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<PatientAddress> updatePatientAddress(@PathVariable("id") long id, @RequestBody PatientAddress patientAddress){
		return new ResponseEntity<PatientAddress>(patientAddressService.updatePatientAddress(patientAddress,id), HttpStatus.OK);
	}
	
}
