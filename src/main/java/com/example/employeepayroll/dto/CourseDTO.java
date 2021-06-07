package com.example.employeepayroll.dto;

import org.springframework.stereotype.Component;

@Component
public class CourseDTO {

	private int id;
	private String courseName;
//	private EmployeeDTO employeeDTO;

	public CourseDTO() {
	}

	public CourseDTO(int id, String courseName) {
		this.id = id;
		this.courseName = courseName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

//	public EmployeeDTO getEmployeeDTO() {
//		return employeeDTO;
//	}
//
//	public void setEmployeeDTO(EmployeeDTO employeeDTO) {
//		this.employeeDTO = employeeDTO;
//	}
}

