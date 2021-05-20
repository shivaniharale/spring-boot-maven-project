package com.example.employeepayroll.dto;

import java.util.List;

import com.example.employeepayroll.entity.Course;
import com.example.employeepayroll.entity.Details;

public class EmployeeDTO {
	
	private int srNum;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private Details details;
	private List<Course> courses;

	public EmployeeDTO() {
		
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}




	public List<Course> getCourses() {
		return courses;
	}




	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}







	public int getSrNum() {
		return srNum;
	}



	public void setSrNum(int srNum) {
		this.srNum = srNum;
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	

}
