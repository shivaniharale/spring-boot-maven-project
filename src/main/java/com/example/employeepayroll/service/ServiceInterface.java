package com.example.employeepayroll.service;

import java.util.List;

import com.example.employeepayroll.entity.Details;
import com.example.employeepayroll.entity.Employee;

public interface ServiceInterface {

	public List<Employee> employeeList();
	
	public void saveOrUpdateEmployee(Employee employee);

	public Employee getEmployee(int id);
	
	public void deleteEmployee(int id );
	

	public List<Details> detailsList();
	
	public void saveOrUpdateDetails(Details details);

	public Details getDetails(int id);
	
	public void deleteDetails(int id);
	
	
	
}
