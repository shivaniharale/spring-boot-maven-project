package com.example.employeepayroll.dao;

import java.util.List;

import com.example.employeepayroll.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> employeeList();
	
	public void saveOrUpdateEmployee(Employee employee);

	public Employee getEmployee(int id);
	
	public void deleteEmployee(int id);
}
