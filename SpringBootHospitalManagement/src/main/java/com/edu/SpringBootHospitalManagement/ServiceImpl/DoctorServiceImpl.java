package com.edu.SpringBootHospitalManagement.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBootHospitalManagement.Entity.Doctor;
import com.edu.SpringBootHospitalManagement.Exception.ResourceNotFound;
import com.edu.SpringBootHospitalManagement.Repository.DoctorRepository;
import com.edu.SpringBootHospitalManagement.Service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	private DoctorRepository doctorRepository;
	
	
	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
	}


	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	} 	 

	@Override
	public List<Doctor> getAllDoctor() {
		return doctorRepository.findAll();
	}


	@Override
	public Doctor getDoctorById(long id) {
		
		Optional<Doctor> doctor = doctorRepository.findById(id);
		
		if(doctor.isPresent()) {
			return doctor.get();
		}else {
			throw new ResourceNotFound("Doctor","id",id);
		}
	}
	
	@Override
	public List<Doctor> getDoctorByDocFirstName(String docFirstName) {
		return doctorRepository.findByDocFirstName(docFirstName);
	}
	
	@Override
	public List<Doctor> getDoctorByDocLastName(String docLastName) {
		return doctorRepository.findByDocLastName(docLastName);
	}
	
	@Override
	public List<Doctor> getDoctorByDocFirstNameAndDocLastName(String docFirstName, String docLastName) {
		return doctorRepository.findByDocFirstNameAndDocLastName(docFirstName,docLastName);
	}
	
	@Override
	public Doctor updateDoctor(Doctor doctor, long id) {
		Doctor doc = new Doctor();
		try {
			doc = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Doctor", "Id", id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		doc.setDocFirstName(doctor.getDocFirstName());
		doc.setDocLastName(doctor.getDocLastName());
		doc.setRoomNo(doctor.getRoomNo());;
		doc.setSpecialization(doctor.getSpecialization());
		doc.setContactNo(doctor.getContactNo());
		doc.setAlternativeNo(doctor.getAlternativeNo());
		doc.setLocation(doctor.getLocation());
		doc.setDepartment(doctor.getDepartment());

		return doctorRepository.save(doc);
	}

	@Override
	public void deleteDoctor(long id) {
		doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Doctor", "Id", id));

		doctorRepository.deleteById(id);
	}

	@Override
	public Doctor getDoctorFullNameByDocId(long docId) {
		return doctorRepository.findDoctorFullNameByDocId(docId);
	}

	@Override
	public List<Doctor> getDoctorInDescOrder() {
		return doctorRepository.findDoctorInDescOrder();
	}

	@Override
	public int getDoctorCount() {
		return doctorRepository.findDoctorCount();
	}

	@Override
	public Doctor patchDoctor(Doctor doctor, long id) {
		Doctor doc = new Doctor();
		try {
			doc = doctorRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Doctor", "Id", id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		doc.setDocFirstName(doctor.getDocFirstName());
		doc.setDocLastName(doctor.getDocLastName());
		doc.setRoomNo(doctor.getRoomNo());;
		doc.setSpecialization(doctor.getSpecialization());
		doc.setContactNo(doctor.getContactNo());
		doc.setAlternativeNo(doctor.getAlternativeNo());
		doc.setLocation(doctor.getLocation());
		doc.setDepartment(doctor.getDepartment());

		return doctorRepository.save(doc);
		
	}


	

}
