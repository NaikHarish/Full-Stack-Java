package com.edu.SpringBootHospitalManagement.Controller;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.SpringBootHospitalManagement.Entity.Doctor;
import com.edu.SpringBootHospitalManagement.Service.DoctorService;

@RestController
@RequestMapping("/api/doctor")

public class DoctorController {
	
	private DoctorService doctorService;

	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	
	@PostMapping
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor), HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<Doctor> getAllDoctor(){
		return doctorService.getAllDoctor();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") long id){
		return new ResponseEntity<Doctor>(doctorService.getDoctorById(id), HttpStatus.CREATED);
	}
	
	@GetMapping("/getDoctorByDocFirstName/{docFirstName}")
	public List<Doctor> getDoctorByDocFirstName(@PathVariable("docFirstName") String docFirstName){
		return doctorService.getDoctorByDocFirstName(docFirstName);
	}
	
	@GetMapping("/getDoctorByDocLastName/{docLastName}")
	public List<Doctor> getDoctorByDocLastName(@PathVariable("docLastName") String docLastName){
		return doctorService.getDoctorByDocLastName(docLastName);
	}
	
	@GetMapping("/getDoctorByDocFirstNameAndDocLastName")
	public List<Doctor> getDoctorByDocFirstNameAndDocLastName(@Param("docFirstName") String docFirstName,
			@Param("docLastname") String docLastName) {
		return doctorService.getDoctorByDocFirstNameAndDocLastName(docFirstName, docLastName);
	}
	
	@GetMapping("/getDoctorFullNameByDocId/{docId}")
	public Doctor getDoctorFullNameByDocId(@PathVariable("docId") long docId) {
		return doctorService.getDoctorFullNameByDocId(docId);
	}

	@GetMapping("/getDoctorInDescOrder")
	public List<Doctor> getDoctorInDescOrder() {
		return doctorService.getDoctorInDescOrder();

	}
	
	@GetMapping("/getDoctorCount")
	public int getDoctorCount() {
		return doctorService.getDoctorCount();
		
	}
	@PutMapping("{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") long id, @RequestBody Doctor doctor) {
		return new ResponseEntity<Doctor>(doctorService.updateDoctor(doctor, id), HttpStatus.OK);

	}
	
	@PatchMapping("{id}")
	public ResponseEntity<Doctor> patchDoctor(@PathVariable("id") long id , @RequestBody Doctor doctor) {
		return new ResponseEntity<Doctor>(doctorService.patchDoctor(doctor,id), HttpStatus.OK);
		
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable("id") long id) {
		doctorService.deleteDoctor(id);
		return new ResponseEntity<String>("Doctor record is deleted", HttpStatus.OK);

	}
	
}
