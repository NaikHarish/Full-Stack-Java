package com.edu.SpringBootHospitalManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.edu.SpringBootHospitalManagement.Entity.Department;
import com.edu.SpringBootHospitalManagement.Entity.Doctor;
import com.edu.SpringBootHospitalManagement.Entity.Patient;
import com.edu.SpringBootHospitalManagement.Service.DepartmentService;
import com.edu.SpringBootHospitalManagement.Service.DoctorService;
import com.edu.SpringBootHospitalManagement.Service.PatientService;


@Controller
public class UIController {

	private DoctorService doctorService;
	private DepartmentService departmentService;
	private PatientService patientService;

	@Autowired
	public UIController(DoctorService doctorService, DepartmentService departmentService,
			PatientService patientService) {
		super();
		this.doctorService = doctorService;
		this.departmentService = departmentService;
		this.patientService = patientService;
	}

	@GetMapping("/")

	String index() {
		return "index";/// index.html
	}

// Doctor 
	@GetMapping("/registration")
	public String doctorRegistrationForm(Model model) {
		Doctor doctor = new Doctor();
		model.addAttribute("doctor", doctor);
		return "add-doctor";
	}

	@PostMapping("/saveDoctor")
	public String saveDoctor(@Validated Doctor doctor, BindingResult result, Model model) {
		if (result.hasErrors())
			return "redirect:/add-doctor";
		else {
			doctorService.saveDoctor(doctor);
//			User user = new User(doctor.getEmailId(), doctor.getPassword(),"ROLE_DOCTOR", true);
//			doctorService.
			model.addAttribute("successMessage", "Details are saved successfully");
		}
		return "redirect:/getDoctors";

	}

	@GetMapping("/getDoctors")
	public String getAllDoctor(Model model) {

		List<Doctor> doctors = doctorService.getAllDoctor();

		model.addAttribute("doctors", doctors);

		return "list-doctor";
	}

// Department 

	@GetMapping("/deptRegister")
	public String deptRegistrationForm(Model model) {
		Department department = new Department();
		model.addAttribute("department", department);
		return "add-dept";
	}

	@PostMapping("/saveDept")
	public String addDept(@Validated Department department, Errors errors, Model model) {
		if (null != errors && errors.getErrorCount() > 0)
			return "redirect:/";
		else {
			departmentService.saveDepartment(department);
			model.addAttribute("successMessage", "Details are saved successfully");
		}
		return "redirect:/getDepts";
	}

	@GetMapping("/getDepts")
	public String getAllDepartment(Model model) {

		List<Department> depts = departmentService.getAllDepartment();

		model.addAttribute("depts", depts);

		return "list-dept";
	}
	
	//Patient
	@GetMapping("/patientRegister")
	public String patientRegistrationForm(Model model) {
		Patient patient = new Patient();
		model.addAttribute("patient",patient);
		return "add-patient";
	}
	
	@GetMapping("/savePatient")
	public String addPatient(@Validated Patient patient,Errors errors,Model model) {
		if (null != errors && errors.getErrorCount()>0) {
			return "redirect:/";
		} else {
			
			patientService.savePatient(patient);
		}
		return "redirect:/getPatients";
	}
	
	@GetMapping("/getPatients")
	public String getAllPatients(Model model) {
		
		List<Patient> patients = patientService.getAllPatients();
		
		model.addAttribute("patients", patients);
		
		return "list-patient";
	}

}