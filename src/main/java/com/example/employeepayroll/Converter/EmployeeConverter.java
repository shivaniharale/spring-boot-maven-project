package com.example.employeepayroll.Converter;

import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.entity.Employee;

@Component
public class EmployeeConverter {

	@Autowired
	AddressConverter addressConverter;

	@Autowired
	SkillConverter skillConverter;

	@Autowired
	CourseConverter courseConverter;

	public EmployeeDTO employeeEntityToDTO(Employee employee) {

		EmployeeDTO dto=new EmployeeDTO();

		dto.setId(employee.getId());
		dto.setFirstName(employee.getFirstName());
		dto.setLastName(employee.getLastName());
		dto.setPhone(employee.getPhone());
		dto.setEmail(employee.getEmail());
		dto.setEmployeeNumber(employee.getEmployeeNumber());
		dto.setSalary(employee.getSalary());
		dto.setPost(employee.getPost());
		dto.setStatus(employee.getStatus());
		dto.setCourses(courseConverter.courseEntityToDTO(employee.getCourses()));
		dto.setAddressDTO(addressConverter.addressEntityToDTO(employee.getAddress()));
		dto.setSkillsDTO(skillConverter.skillEntityToDTO(employee.getSkills()));

		return dto;
	}

	public List<EmployeeDTO> employeeEntityToDTO(List<Employee> employees) {
		return employees.stream().map(x->employeeEntityToDTO(x)).collect(Collectors.toList());
	}

	public Employee employeeDtoToEntity(EmployeeDTO dto) {

		Employee employee=new Employee();

		employee.setId(dto.getId());
		employee.setFirstName(dto.getFirstName());
		employee.setLastName(dto.getLastName());
		employee.setPhone(dto.getPhone());
		employee.setEmail(dto.getEmail());
		employee.setEmployeeNumber(dto.getEmployeeNumber());
		employee.setSalary(dto.getSalary());
		employee.setPost(dto.getPost());
		employee.setStatus(dto.getStatus());
		employee.setCourses(courseConverter.courseDtoToEntity(dto.getCourses()));
		employee.setAddress(addressConverter.addressDtoToEntity(dto.getAddressDTO()));
		employee.setSkills(skillConverter.skillDtoToEntity(dto.getSkillsDTO()));

		return employee;
	}

	public List<Employee> employeeDtoToEntity(List<EmployeeDTO> dtos) {

		return dtos.stream().map(x->employeeDtoToEntity(x)).collect(Collectors.toList());

	}
}