package com.edu.SpringBootHospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBootHospitalManagement.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

}
