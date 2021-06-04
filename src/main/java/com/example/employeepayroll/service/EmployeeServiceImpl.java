package com.example.employeepayroll.service;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;


import com.example.employeepayroll.Converter.SkillConverter;
import com.example.employeepayroll.dto.SkillDTO;
import com.example.employeepayroll.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeepayroll.Converter.EmployeeConverter;
import com.example.employeepayroll.dao.EmployeeDAO;
import com.example.employeepayroll.dto.EmployeeDTO;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private EmployeeConverter employeeConverter;

	@Autowired
	private SkillConverter skillConverter;

	private static final java.util.logging.Logger LOGGER= Logger.getLogger(String.valueOf(EmployeeServiceImpl.class));


	@Override
	public List<EmployeeDTO> employeeList() {
		try {
			return employeeConverter.employeeEntityToDTO(employeeDAO.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResponseEntity<?> saveEmployee(EmployeeDTO employeeDTO) {
		try {
		return ResponseEntity.ok(employeeDAO.save(employeeConverter.employeeDtoToEntity(employeeDTO)));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

		@Override
	public List<EmployeeDTO> getEmployeeByFirstName(String firstName) {
		try {

			LOGGER.warning("INSIDE SERVICE:"+firstName);

			return employeeConverter.employeeEntityToDTO(employeeDAO.findByFirstName(firstName));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

		@Override
	public List<EmployeeDTO> getEmployeeByLastName(String lastName) {
		try {
			return employeeConverter.employeeEntityToDTO(employeeDAO.findByLastName(lastName));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public EmployeeDTO getEmployee(int id) {
		try {
			return employeeConverter.employeeEntityToDTO(employeeDAO.findById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResponseEntity<?> deleteEmployee(int id) {

		try {
			employeeDAO.deleteById(id);
			return ResponseEntity.ok("Delete successful");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public EmployeeDTO getEmployeeByEmployeeNumber(int employeeNumber) {
		try {
			return employeeConverter.employeeEntityToDTO(employeeDAO.findByEmployeeNumber(employeeNumber));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<EmployeeDTO> getEmployeeByStatus(String status) {
		try {
			return employeeConverter.employeeEntityToDTO(employeeDAO.findByStatus(status));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<EmployeeDTO> getEmployeeByPost(String post) {
		try {
			return employeeConverter.employeeEntityToDTO(employeeDAO.findByPost(post));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<EmployeeDTO> getEmployeeBySkill(Skill skill) {
		return employeeConverter.employeeEntityToDTO(employeeDAO.findBySkills(skill));
	}

//
//	@Override
//	public Set<SkillDTO> getSkillsByEmployees(String firstName, String lastName) {
//		Employee employee=new Employee();
////		employee=employeeConverter.employeeEntityToDTO(employeeDAO.findByFirstNameLastName(firstName,lastName));
//
//		return null;
//
//	}


}
