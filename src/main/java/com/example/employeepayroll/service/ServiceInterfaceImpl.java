package com.example.employeepayroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeepayroll.dao.DetailsDAO;
import com.example.employeepayroll.dao.EmployeeDAO;
import com.example.employeepayroll.entity.Details;
import com.example.employeepayroll.entity.Employee;
 
@Service
@Transactional
public class ServiceInterfaceImpl implements ServiceInterface {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private DetailsDAO detailsDAO;
	
	@Override
	public List<Employee> employeeList() {
				
		return 	employeeDAO.employeeList();
	}

	@Override
	public void saveOrUpdateEmployee(Employee employee) {
		
		employeeDAO.saveOrUpdateEmployee(employee);
		
	}

	@Override
	public Employee getEmployee(int id) {
		Employee employee=employeeDAO.getEmployee(id);
		return employee;
	}

	@Override
	public void deleteEmployee(int id) {

		employeeDAO.deleteEmployee(id);
		
	}

	@Override
	public List<Details> detailsList() {
		
		return detailsDAO.detailsList();
	}

	@Override
	public void saveOrUpdateDetails(Details details) {

		detailsDAO.saveOrUpdateDetails(details);
	}

	@Override
	public Details getDetails(int id) {
		Details details=detailsDAO.getDetails(id);
		return details;
	}

	@Override
	public void deleteDetails(int id) {
		detailsDAO.deleteDetails(id);
		
	}

	
	
	
}
