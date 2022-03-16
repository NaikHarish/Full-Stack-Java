package com.edu.SpringBootHospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBootHospitalManagement.Entity.PatientAddress;

public interface PatientAddressRepository extends JpaRepository<PatientAddress, Long>{

}
