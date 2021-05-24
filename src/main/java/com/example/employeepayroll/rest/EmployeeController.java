package com.example.employeepayroll.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.service.ServiceInterface;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private ServiceInterface service;


	@GetMapping("/employees")
	public List<EmployeeDTO> getEmployeeList(){

		List<EmployeeDTO> list=service.employeeList();
		if (list!=null) {
			return service.employeeList();
		} else {
			throw new NullPointerException("Invalid input/Employee list is empty");
		}

	}

//	@GetMapping("/employees/{firstName}")
//	public List<EmployeeDTO> getEmployeeByFirstName(@PathVariable String firstName){
//
//		return service.getEmployeeByFirstName(firstName);
//
//	}
//
//	@GetMapping("/employees/{lastName}")
//	public List<EmployeeDTO> getEmployeeByLastName(@PathVariable String lastName){
//
//		return service.getEmployeeByLastName(lastName);
//
//	}
//
//	@GetMapping("/employees/{employeeNumber}")
//	public EmployeeDTO getEmployeeByEmployeeNumber(@PathVariable int employeeNumber){
//
//		return service.getEmployeeByEmployeeNumber(employeeNumber);
//
//	}
//
//	@GetMapping("/employees/{post}")
//	public List<EmployeeDTO> getEmployeeByPost(@PathVariable String post){
//
//		return service.getEmployeeByPost(post);
//
//	}
//
//	@GetMapping("/employees/{status}")
//	public List<EmployeeDTO> getEmployeeByStatus(@PathVariable String status){
//
//		return service.getEmployeeByStatus(status);
//
//	}


	@PostMapping("/employees")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO){

		employeeDTO.setId(0);

		service.saveOrUpdateEmployee(employeeDTO);

		return ResponseEntity.status(HttpStatus.OK).body("Employee Saved Successfully");

	}

	@PutMapping("/employees")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDTO employeeDTO){

		service.saveOrUpdateEmployee(employeeDTO);

		return ResponseEntity.status(HttpStatus.OK).body("Employee Updated Successfully");
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){

		if(service.getEmployee(id)!=null)
			service.deleteEmployee(id);
		else {
			throw new NullPointerException();
		}

		return ResponseEntity.status(HttpStatus.OK).body("Employee Deleted Successfully");

	}



}
