package com.example.employeepayroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeepayroll.Converter.EmployeeDetailsConverter;
import com.example.employeepayroll.dao.DetailsDAO;
import com.example.employeepayroll.dao.EmployeeDAO;
import com.example.employeepayroll.dto.DetailsDTO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.entity.Details;
import com.example.employeepayroll.entity.Employee;
 
@Service
@Transactional
public class ServiceInterfaceImpl implements ServiceInterface {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private DetailsDAO detailsDAO;
	
	@Autowired
	private EmployeeDetailsConverter employeeDetailsConverter;
	
	@Override
	public List<EmployeeDTO> employeeList() {
			
		List<Employee> list=employeeDAO.employeeList();
		
		return employeeDetailsConverter.employeeEntityToDTO(list);
		
	}

	@Override
	public void saveOrUpdateEmployee(EmployeeDTO employeeDTO) {
		
		Employee employee=employeeDetailsConverter.employeeDtoToEntity(employeeDTO);
		
		employeeDAO.saveOrUpdateEmployee(employee);
		
	}

	@Override
	public EmployeeDTO getEmployee(int id) {
		
		Employee employee=employeeDAO.getEmployee(id);
		
		return employeeDetailsConverter.employeeEntityToDTO(employee);
	}

	@Override
	public void deleteEmployee(int id) {

//		employeeDAO.deleteEmployee(id);
	
	}

	@Override
	public List<DetailsDTO> detailsList() {
		
		List<Details> list=detailsDAO.detailsList();
		
		return employeeDetailsConverter.detailsEntityToDTO(list);
		
	}

//	@Override
//	public void saveOrUpdateDetails(DetailsDTO detailsDTO) {
//
//		Details details=employeeDetailsConverter.detailsDtoToEntity(detailsDTO);
//		
//		detailsDAO.saveOrUpdateDetails(details);
//		
//	}

	@Override
	public DetailsDTO getDetails(int id) {
		Details details=detailsDAO.getDetails(id);
		return employeeDetailsConverter.detailsEntityToDTO(details);
	}

	
}
