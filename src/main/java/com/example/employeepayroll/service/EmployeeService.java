package com.example.employeepayroll.service;

import java.util.List;
import java.util.Set;

import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.dto.SkillDTO;
import com.example.employeepayroll.entity.Skill;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

	public List<EmployeeDTO> employeeList();

	public ResponseEntity<?> saveEmployee(EmployeeDTO employeeDTO);

	public List<EmployeeDTO> getEmployeeByFirstName(String firstName);

	public List<EmployeeDTO> getEmployeeByLastName(String lastName);

	public EmployeeDTO getEmployee(int id);

	public ResponseEntity<?> deleteEmployee(int id);

	public EmployeeDTO getEmployeeByEmployeeNumber(int employeeNumber);

	public List<EmployeeDTO> getEmployeeByStatus(String status);

	public List<EmployeeDTO> getEmployeeByPost(String post);

//	List<EmployeeDTO> getEmployeeBySkill(Skill skill);

    List<SkillDTO> getEmployeeSkills(int id);

	List<CourseDTO> getEmployeeCourses(int id);
}
