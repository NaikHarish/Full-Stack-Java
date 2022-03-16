package com.edu.SpringBootHospitalManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBootHospitalManagement.Entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long>{

}
