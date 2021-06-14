package com.example.employeepayroll.rest;

import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.repository.EmployeeRepo;
import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.dto.EmployeeDTO;

import com.example.employeepayroll.dto.SkillDTO;
import com.example.employeepayroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@Autowired
	private EmployeeRepo employeeRepo;

	private static final Logger LOGGER= Logger.getLogger(String.valueOf(EmployeeController.class));

	@GetMapping("/employees")
	public List<EmployeeDTO> getEmployeeList() {
		List<EmployeeDTO> list = service.employeeList();
		if (list != null) {
			return service.employeeList();
		} else {
			throw new NullPointerException("Employee list is empty");
		}
	}

	@PostMapping("/employees")
	public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		employeeDTO.setId(0);
		return ResponseEntity.ok(service.saveEmployee(employeeDTO));
	}

	@PutMapping("/employees")
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {

		return ResponseEntity.ok(service.updateEmployee(employeeDTO));
	}


	@GetMapping("/firstNameLastName/{firstName}/{lastName}")
	public Employee saveEmployeeSkill(@PathVariable String firstName, @PathVariable String lastName){
		Employee e=employeeRepo.findByFirstNameLastName(firstName,lastName);
		return e;
	}

	@RequestMapping(value = "/firstName/{firstName}",method = RequestMethod.GET)
	public List<EmployeeDTO> getEmployeeByFirstName(@PathVariable String firstName) {
		try {

			return service.getEmployeeByFirstName(firstName);
		} catch (Exception e) {
			System.out.println("Employee not found" + e.toString());
			return null;
		}
	}


	@GetMapping("/lastName/{lastName}")
	public List<EmployeeDTO> getEmployeeByLastName(@PathVariable String lastName) {
		try {
			return service.getEmployeeByLastName(lastName);
		} catch (Exception e) {
			System.out.println("Employee not found" + e.toString());
			return null;
		}
	}

	@GetMapping("/employeeNumber/{employeeNumber}")
	public EmployeeDTO getEmployeeByEmployeeNumber(@PathVariable int employeeNumber) {
		try {
			return service.getEmployeeByEmployeeNumber(employeeNumber);
		} catch (Exception e) {
			System.out.println("Employee not found" + e.toString());
			return null;
		}
	}

	@GetMapping("/post/{post}")
	public List<EmployeeDTO> getEmployeeByPost(@PathVariable String post) {
		try {
			return service.getEmployeeByPost(post);
		} catch (Exception e) {
			System.out.println("Employee not found" + e.toString());
			return null;
		}
	}

	@GetMapping("/status/{status}")
	public List<EmployeeDTO> getEmployeeByStatus(@PathVariable String status) {
		try {
			return service.getEmployeeByStatus(status);
		} catch (Exception e) {
			System.out.println("Employee not found" + e.toString());
			return null;
		}
	}

	@GetMapping("/skills/{id}")
	public List<SkillDTO> getEmployeeSkills(@PathVariable int id) {
		try {
			return service.getEmployeeSkills(id);
		} catch (Exception e) {
			System.out.println("Skills not found" + e.toString());
			return null;
		}
	}

	@GetMapping("/courses/{id}")
	public List<CourseDTO> getEmployeeCourses(@PathVariable int id) {
		try {
			return service.getEmployeeCourses(id);
		} catch (Exception e) {
			System.out.println("Skills not found" + e.toString());
			return null;
		}
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		if (service.getEmployee(id) != null){
			service.deleteEmployee(id);
		return ResponseEntity.ok("DELETE SUCCESSFUL");
	}
		else {
			throw new NullPointerException("Employee to be deleted not found.");
		}
	}



}
