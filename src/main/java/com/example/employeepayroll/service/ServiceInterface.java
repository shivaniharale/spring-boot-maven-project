package com.example.employeepayroll.service;

import java.util.List;

import com.example.employeepayroll.dto.DetailsDTO;
import com.example.employeepayroll.dto.EmployeeDTO;

public interface ServiceInterface {

	public List<EmployeeDTO> employeeList();
	
	public void saveOrUpdateEmployee(EmployeeDTO employeeDTO);

	public EmployeeDTO getEmployee(int id);
	
	public void deleteEmployee(int id);
	

	public List<DetailsDTO> detailsList();
	
//	public void saveOrUpdateDetails(DetailsDTO detailsDTO);

	public DetailsDTO getDetails(int id);

}
