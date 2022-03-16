package com.edu.SpringBootHospitalManagement.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.SpringBootHospitalManagement.Entity.Patient;
import com.edu.SpringBootHospitalManagement.Service.PatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {
	
	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	@PostMapping
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientService.savePatient(patient),HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable("id") long id){
		
		return new ResponseEntity<Patient>(patientService.getPatientById(id), HttpStatus.FOUND);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id, @RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientService.updatePatient(patient,id), HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deletePatient(@PathVariable("id") long id){
		patientService.deletePatient(id);
		return new ResponseEntity<String>("Patient Record is Deleted", HttpStatus.OK);
		
	}
}
