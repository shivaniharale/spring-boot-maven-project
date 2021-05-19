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

import com.example.employeepayroll.dto.DetailsDTO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.service.ServiceInterface;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private ServiceInterface service;
	
	@GetMapping("/employees")
	public List<EmployeeDTO> getEmployeeList(){
		
		return service.employeeList();
	}
	
	@GetMapping("/employees/{id}")
	public EmployeeDTO getEmployee(@PathVariable int id){
		
		return service.getEmployee(id);

	}
	
	@PostMapping("/employees")
	public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO){
		
		employeeDTO.setId(0);
		
		service.saveOrUpdateEmployee(employeeDTO);
	
		return employeeDTO;
	}
	
	@PutMapping("/employees")
	public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO){
		
		service.saveOrUpdateEmployee(employeeDTO);
		
		return employeeDTO;
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id){
		
		if(service.getEmployee(id)!=null)		
		service.deleteEmployee(id);
		
	}
	
	@GetMapping("/employeedetails")
	public List<DetailsDTO> getDetailsList(){
		
		return service.detailsList();
	}
	
	@GetMapping("/employeedetails/{id}")
	public DetailsDTO getDetails(@PathVariable int id){
		
		return service.getDetails(id);
	}
	
//	@PostMapping("/employeedetails")
//	public DetailsDTO createDetails(@RequestBody DetailsDTO detailsDTO){
//		
//		service.saveOrUpdateDetails(detailsDTO);
//	
//		return detailsDTO;
//	}
//	
//	@PutMapping("/employeedetails")
//	public DetailsDTO updateDetails(@RequestBody DetailsDTO detailsDTO){
//		
//		service.saveOrUpdateDetails(detailsDTO);
//		
//		return detailsDTO;
//	
//	}

}
