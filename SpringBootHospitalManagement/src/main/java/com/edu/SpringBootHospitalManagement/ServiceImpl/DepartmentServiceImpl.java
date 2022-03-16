package com.edu.SpringBootHospitalManagement.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBootHospitalManagement.Entity.Department;
import com.edu.SpringBootHospitalManagement.Exception.ResourceNotFound;
import com.edu.SpringBootHospitalManagement.Repository.DepartmentRepository;
import com.edu.SpringBootHospitalManagement.Service.DepartmentService;



@Service
public class DepartmentServiceImpl implements DepartmentService{
	
private DepartmentRepository departmentRepository;
	
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}


	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}


	@Override
	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}


	@Override
	public Department getDepartmentById(long id) {
		Optional<Department> department = departmentRepository.findById(id);
		if(department.isPresent()) {
			return department.get();
		}else {
			throw new ResourceNotFound("Department", "id", id);
		}
	}


	@Override
	public Department updateDepartment(Department department, long id) {
		Department dept = new Department();
		try {
			dept = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFound("department", "Id", id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dept.setDeptName(department.getDeptName());
		return departmentRepository.save(dept);
				
	}


	@Override
	public Department getDepartmentByDeptName(String deptName) {
		return null;
	}
	
}
