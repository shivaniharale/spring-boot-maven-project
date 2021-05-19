package com.example.employeepayroll.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="srNum")
	private int srNum;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	

	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="details_id")
	private Details details;
	
	
	public Employee() {
		
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
	
	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Employee [id=" + srNum + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", email=" + email + ", details=" + details + "]";
	}

	
	
}
