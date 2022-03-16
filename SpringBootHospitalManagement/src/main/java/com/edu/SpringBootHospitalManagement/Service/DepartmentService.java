package com.edu.SpringBootHospitalManagement.Service;

import java.util.List;

import com.edu.SpringBootHospitalManagement.Entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> getAllDepartment();

	Department getDepartmentById(long id);

	Department getDepartmentByDeptName(String deptName);

	Department updateDepartment(Department department, long id);

}
