package com.example.employeepayroll.Converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.employeepayroll.dto.DetailsDTO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.entity.Details;
import com.example.employeepayroll.entity.Employee;

@Component
public class EmployeeDetailsConverter {
	


	public EmployeeDTO employeeEntityToDTO(Employee employee) {
				
		ModelMapper modelMapper=new ModelMapper();
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

		EmployeeDTO dto=modelMapper.map(employee, EmployeeDTO.class);
				
		return dto;		
	}
	
	public List<EmployeeDTO> employeeEntityToDTO(List<Employee> employees) {

		return employees.stream().map(x->employeeEntityToDTO(x)).collect(Collectors.toList());
		
	}
	
	public Employee employeeDtoToEntity(EmployeeDTO dto) {
				
		ModelMapper modelMapper=new ModelMapper();

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

		Employee employee=modelMapper.map(dto, Employee.class);

		return employee;
	}
	
	public List<Employee> employeeDtoToEntity(List<EmployeeDTO> dtos) {
		
		return dtos.stream().map(x->employeeDtoToEntity(x)).collect(Collectors.toList());

	}

	
	public DetailsDTO detailsEntityToDTO(Details details) {
		
//		DetailsDTO dto=new DetailsDTO();
//		dto.setId(details.getId());
//		dto.setEmployeeNumber(details.getEmployeeNumber());
//		dto.setSalary(details.getSalary());
//		dto.setPost(details.getStatus());
		
		ModelMapper modelMapper=new ModelMapper();
	
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		
		DetailsDTO dto=modelMapper.map(details, DetailsDTO.class);

		return dto;
		
	}
	
	public List<DetailsDTO> detailsEntityToDTO(List<Details> details) {

		return details.stream().map(x->detailsEntityToDTO(x)).collect(Collectors.toList());

	}
	
	public Details detailsDtoToEntity(DetailsDTO dto) {
		
//		Details details=new Details();
//		details.setId(dto.getId());
//		details.setEmployeeNumber(dto.getEmployeeNumber());
//		details.setSalary(dto.getSalary());
//		details.setPost(dto.getPost());
		
		ModelMapper modelMapper=new ModelMapper();

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

		Details details=modelMapper.map(dto, Details.class);

		return details;
	}
	
	public List<Details> detailsDtoToEntity(List<DetailsDTO> dtos) {

		return dtos.stream().map(x->detailsDtoToEntity(x)).collect(Collectors.toList());

	}

	
}
