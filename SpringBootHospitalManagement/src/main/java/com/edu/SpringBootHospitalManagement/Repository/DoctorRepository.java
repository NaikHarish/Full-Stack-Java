package com.edu.SpringBootHospitalManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.SpringBootHospitalManagement.Entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
	List<Doctor> findByDocFirstName(String docFirstName);

	List<Doctor> findByDocLastName(String docLastName);

	List<Doctor> findByDocFirstNameAndDocLastName(String docFirstName, String docLastName);
	
	@Query("select d from com.edu.SpringBootDemo.entity.Doctor d where d.docFirstName = :docFirstName and d.docLastName = :docLastName")
	List<Doctor> findDoctorByDocFirstNameAndDocLastName(@Param("docFirstName") String docFirstName, @Param("docLastName") String docLastName);

	@Query("select new com.edu.SpringBootDemo.entity.Doctor(d.docFirstName , d.docLastName) from com.edu.SpringBootDemo.entity.Doctor d where d.docId = :docId")
	Doctor findDoctorFullNameByDocId(@Param("docId") long docId);
	
	@Query("select d from com.edu.SpringBootDemo.entity.Doctor d ORDER BY d.docFirstName desc")
	List<Doctor> findDoctorInDescOrder();
	
	@Query("select count(d.docId) from com.edu.SpringBootDemo.entity.Doctor d")
	int findDoctorCount();
	
}
