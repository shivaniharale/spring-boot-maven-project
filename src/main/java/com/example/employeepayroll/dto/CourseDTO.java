package com.example.employeepayroll.dto;

import com.example.employeepayroll.entity.Employee;

public class CourseDTO {

	private int id;
	private String courseName;
	private Employee employeeCourse;

	public CourseDTO() {
		
	
	}

	public Employee getEmployeeCourse() {
		return employeeCourse;
	}

	public void setEmployeeCourse(Employee employeeCourse) {
		this.employeeCourse = employeeCourse;
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

}
