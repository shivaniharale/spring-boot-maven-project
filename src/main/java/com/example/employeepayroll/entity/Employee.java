package com.example.employeepayroll.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.mockito.internal.matchers.Null;

@Entity
@Table(name="employee")
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="phone")
	private String phone;

	@Column(name="email")
	private String email;

	@Column(name="employee_number")
	private int employeeNumber;

	@Column(name="salary")
	private int salary;

	@Column(name="post")
	private String post;

	@Column(name="status")
	private String status;

	@OneToOne( cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	@JsonIgnore
	private Address address;

	@OneToOne(mappedBy = "employee")
	@JsonIgnore
	private UserEntity userEntity;

	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Course> courses;

	@ManyToMany(mappedBy = "employeeSet",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Skill> skills;

	public Employee() {

	}

	public Employee(int id,String firstName, String lastName, String phone, String email, int employeeNumber) {
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.employeeNumber = employeeNumber;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
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

	public void addCourse(Course course) {

		if (courses == null) {
			courses = new ArrayList<>();
		}
		courses.add(course);
		course.setEmployee(this);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public void addSkill(Skill skill) {

		if(skills== null){
			List<Skill> skills=new ArrayList<>();
		}
		skills.add(skill);
		skill.addEmployee(this);
	}


}