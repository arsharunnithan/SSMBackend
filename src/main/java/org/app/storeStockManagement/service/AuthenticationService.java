package org.app.storeStockManagement.service;

import org.app.storeStockManagement.model.Employee;
import org.app.storeStockManagement.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	@Autowired
	private AuthenticationRepository authRepository;
	
	//take input as employee object and save this object to the database
	public Employee saveEmployee(Employee employee){
		return authRepository.save(employee);
	}
	//to verify if the data is existing or not
	public Employee fetchEmployeeByEmailId(String email) {
		return authRepository.findAllByEmailId(email);
	}
	//check combination of user name and password
	public Employee fetchEmployeeByEmailIdAndPassword(String email, String password) {
		return authRepository.findAllByEmailIdAndPassword(email, password);
	}
	
}
