package com.example.employeepayroll.dto;

public class DetailsDTO {
	private int id;
	private int employeeNumber;
	private int salary;
	private String post;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "DetailsDTO [id=" + id + ", employeeNumber=" + employeeNumber + ", salary=" + salary + ", post=" + post
				+ "]";
	}
	
	

}
