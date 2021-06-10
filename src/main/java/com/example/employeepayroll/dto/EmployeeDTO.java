package com.example.employeepayroll.dto;

import com.example.employeepayroll.entity.Skill;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	private AddressDTO addressDTO;
	private List<SkillDTO> skillsDTO;

	public EmployeeDTO() {

	}


	public EmployeeDTO(int id,String firstName, String lastName, String phone, String email, int employeeNumber) {
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.employeeNumber = employeeNumber;
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

	public List<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDTO> courses) {
		this.courses = courses;
	}

	public AddressDTO getAddressDTO() {
		return addressDTO;
	}

	public void setAddressDTO(AddressDTO addressDTO) {
		this.addressDTO = addressDTO;
	}

	public List<SkillDTO> getSkillsDTO() {
		return skillsDTO;
	}

	public void setSkillsDTO(List<SkillDTO> skillsDTO) {
		this.skillsDTO = skillsDTO;
	}

	@Override
	public String toString() {
		return "EmployeeDTO{" +
					   "id=" + id +
					   ", firstName='" + firstName + '\'' +
					   ", lastName='" + lastName + '\'' +
					   ", phone='" + phone + '\'' +
					   ", email='" + email + '\'' +
					   ", employeeNumber=" + employeeNumber +
					   ", salary=" + salary +
					   ", post='" + post + '\'' +
					   ", status='" + status + '\'' +
					   ", courses=" + courses +
					   ", addressDTO=" + addressDTO +
					   ", skillsDTO=" + skillsDTO +
					   '}';
	}
}
