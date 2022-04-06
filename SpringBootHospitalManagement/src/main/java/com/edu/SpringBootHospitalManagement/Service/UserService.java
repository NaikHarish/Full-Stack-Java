package com.edu.SpringBootHospitalManagement.Service;

import java.util.Optional;

import com.edu.SpringBootHospitalManagement.Entity.User;


public interface UserService {
	
	public Optional<User> findByUserName(String userName);
	
	
}
