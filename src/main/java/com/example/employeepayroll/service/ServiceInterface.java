package com.example.employeepayroll.service;

import java.util.List;

import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;

public interface ServiceInterface {

	public List<EmployeeDTO> employeeList();

	public ResponseEntity<String> saveOrUpdateEmployee(EmployeeDTO employeeDTO);

	public EmployeeDTO getEmployee(int id);

	public ResponseEntity<String> deleteEmployee(int id);

	public List<CourseDTO> getEmployeeCourses(int id);

	public ResponseEntity<String> saveOrUpdateCourseList(CourseDTO newCourse);

	public List<CourseDTO> getEmployeeCourses();

	public List<EmployeeDTO> getEmployeeByFirstName(String firstName);

	public EmployeeDTO getEmployeeByEmployeeNumber(int employeeNumber);

	public List<EmployeeDTO> getEmployeeByLastName(String lastName);

	public List<EmployeeDTO> getEmployeeByStatus(String status);

	public List<EmployeeDTO> getEmployeeByPost(String post);

	public EmployeeDTO getEmployeeByEmail(String email);

	public EmployeeDTO getEmployeeByPhone(String phone);


}
