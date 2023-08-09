package org.app.storeStockManagement.controller;

import org.app.storeStockManagement.model.Employee;
import org.app.storeStockManagement.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authService;
	//method will get mapped whenever employee submit the form
	@PostMapping("/registerEmployee")
	@CrossOrigin(origins = "http://localhost:4200")
	public Employee registerEmployee(@RequestBody Employee employee) throws Exception
	{
		//to check if the data is existing or not
		String tempEmailId=employee.getEmailId();
		if(tempEmailId!=null && !"".equals(tempEmailId)) {
			Employee employeeObj=authService.fetchEmployeeByEmailId(tempEmailId);
			if(employeeObj!=null) {
				throw new Exception("Employee "+tempEmailId+" already exists");
			}
		}
		Employee employeeObj=null;
		employeeObj=authService.saveEmployee(employee);
		return employeeObj;
	}
	@PostMapping("/loginEmployee")
	@CrossOrigin(origins = "http://localhost:4200")
	public Employee loginEmployee(@RequestBody Employee employee) throws Exception{
		String tempEmailId=employee.getEmailId();
		String tempPassword=employee.getPassword();
		Employee employeeObj=null;
		if(tempEmailId!=null && tempPassword!=null)
		{
			employeeObj=authService.fetchEmployeeByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		if(employeeObj==null) {
			throw new Exception("Employee "+tempEmailId+" does not exist");
		}
		return employeeObj;
	}
}

