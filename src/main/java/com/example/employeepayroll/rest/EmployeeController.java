package com.example.employeepayroll.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeepayroll.entity.Details;
import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.service.ServiceInterface;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private ServiceInterface service;
	
	
	@GetMapping("/loginPage")
	public String getloginPage() {
		
		return "loginpage";
	}
	
	
//	@GetMapping("employees")
//	public String getloginPage() {
//		
//		return "employees";
//	}
	
	
	

	@GetMapping("/employees")
	public List<Employee> getEmployeeList(){
		
		return service.employeeList();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable int id){
		
		return service.getEmployee(id);

	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee){
		
		employee.setId(0);
		
		service.saveOrUpdateEmployee(employee);
	
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee){
		
		service.saveOrUpdateEmployee(employee);
		
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id){
		
		if(service.getEmployee(id)!=null)		
		service.deleteEmployee(id);
		
	}
	
	@GetMapping("/employeedetails")
	public List<Details> getDetailsList(){
		
		return service.detailsList();
	}
	
	@GetMapping("/employeedetails/{id}")
	public Details getDetails(@PathVariable int id){
		
		return service.getDetails(id);
	}

	
	
	
}
