package com.example.employeepayroll.dto;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDTO {


	private int id;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private int employeeNumber;
	private int salary;
	private String post;
	private String status;
	private List<CourseDTO> courses;



	public EmployeeDTO() {

	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



//	public List<Course> getCourses() {
//		return courses;
//	}
//
//
//
//
//	public void setCourses(List<Course> courses) {
//		this.courses = courses;
//	}






	public List<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDTO> courses) {

		this.courses = courses;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
