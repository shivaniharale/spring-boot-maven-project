package com.example.employeepayroll.dto;

public class EmployeeDTO {
	
	private String firstName;
	private String lastName;
	private String phone;
	private String email;

	private int detailId;
	private int employeeNumber;
	private int salary;
	private String post;
	
	public EmployeeDTO() {
		
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
	
	

	public int getId() {
		return detailId;
	}

	public void setId(int id) {
		this.detailId = id;
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


	

}
