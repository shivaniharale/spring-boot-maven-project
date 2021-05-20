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
	

Logger log = Logger.getLogger(EmployeeConverter.class.getName());
	
	@Autowired
	EmployeeConverter employeeConverter;

	public EmployeeDTO employeeEntityToDTO(Employee employee) {

//		EmployeeDTO dto=new EmployeeDTO();
//
//		dto.setSrNum(employee.getSrNum());
//		dto.setFirstName(employee.getFirstName());
//		dto.setLastName(employee.getLastName());
//		dto.setPhone(employee.getPhone());
//		dto.setEmail(employee.getEmail());
//		dto.setDetails(employee.getDetails());

		ModelMapper mapper=new ModelMapper();
		log.info(employee);
		EmployeeDTO dto=mapper.map(employee,EmployeeDTO.class);
		log.info(dto);
		mapper.getConfiguration()
		  .setMatchingStrategy(MatchingStrategies.STRICT);
		log.info("NEW"+dto);
//		dto.setCourses(employee.getCourses().stream().map(employeeConverter::employeeEntityToDTO).collect(Collectors.toList()));


		return dto;		
	}	


	public List<EmployeeDTO> employeeEntityToDTO(List<Employee> employees) {
		
		return employees.stream().map(x->employeeEntityToDTO(x)).collect(Collectors.toList());

//	double a=employees.size();
//		
//		List<EmployeeDTO> list = a.stream().map(employees -> {
//			EmployeeDTO employeeDTO = new EmployeeDTO();
//            try {
//                PropertyUtils.copyProperties(employeeDTO, employees);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//            return employeeDTO;
//        }).collect(Collectors.toList());
//
//        list.forEach(System.out::println);
//        
//        return list;
		
		
	}

	public Employee employeeDtoToEntity(EmployeeDTO dto) {

		//		ModelMapper modelMapper=new ModelMapper();

//		Employee employee=new Employee();
//
//		employee.setSrNum(dto.getSrNum());
//		employee.setFirstName(dto.getFirstName());
//		employee.setLastName(dto.getLastName());
//		employee.setPhone(dto.getPhone());
//		employee.setEmail(dto.getEmail());
//		employee.setDetails(dto.getDetails());

	//	employee.setCourses(dto.getCourses().stream().map(employeeConverter::employeeDtoToEntity).collect(Collectors.toList()));


ModelMapper mapper=new ModelMapper();
		
		Employee employee=mapper.map(dto,Employee.class);
		
		mapper.getConfiguration()
		  .setMatchingStrategy(MatchingStrategies.STRICT);
		
		return employee;
	}

	public List<Employee> employeeDtoToEntity(List<EmployeeDTO> dtos) {

		return dtos.stream().map(x->employeeDtoToEntity(x)).collect(Collectors.toList());

	}
}