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

import com.edu.SpringBootHospitalManagement.Entity.Department;
import com.edu.SpringBootHospitalManagement.Service.DepartmentService;


@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	@PostMapping
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
		return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Department> getAllDepartment(){
		return departmentService.getAllDepartment();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long id){
		return new ResponseEntity<Department>(departmentService.getDepartmentById(id), HttpStatus.FOUND);
		
	}
	
	@GetMapping("/getDepartmentByDeptName")
	public ResponseEntity<Department> getDepartmentByDeptName(@PathVariable("deptName") String deptName){
		return new ResponseEntity<Department>(departmentService.getDepartmentByDeptName(deptName), HttpStatus.FOUND);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable("id") long id , @RequestBody Department department){
		return new ResponseEntity<Department>(departmentService.updateDepartment(department,id), HttpStatus.OK);
	}
	
}
