package com.example.employeepayroll.service;

import java.util.List;
import java.util.logging.Logger;


import com.example.employeepayroll.Converter.CourseConverter;
import com.example.employeepayroll.Converter.SkillConverter;
import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.dto.SkillDTO;
import com.example.employeepayroll.entity.Course;
import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.entity.Skill;
import com.example.employeepayroll.entity.UserEntity;
import com.example.employeepayroll.repository.UserEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeepayroll.Converter.EmployeeConverter;
import com.example.employeepayroll.repository.EmployeeRepo;
import com.example.employeepayroll.dto.EmployeeDTO;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private EmployeeConverter employeeConverter;

	@Autowired
	private SkillConverter skillConverter;

	@Autowired
	private CourseConverter courseConverter;

	@Autowired
	private UserEntityRepo userEntityRepo;

	private static final java.util.logging.Logger LOGGER= Logger.getLogger(String.valueOf(EmployeeServiceImpl.class));


	@Override
	public List<EmployeeDTO> employeeList() {
		try {
			return employeeConverter.employeeEntityToDTO(employeeRepo.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResponseEntity<?> saveEmployee(EmployeeDTO employeeDTO) {
		try {
		return ResponseEntity.ok(employeeRepo.save(employeeConverter.employeeDtoToEntity(employeeDTO)));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

		@Override
	public List<EmployeeDTO> getEmployeeByFirstName(String firstName) {
		try {

			LOGGER.warning("INSIDE SERVICE:"+firstName);

			return employeeConverter.employeeEntityToDTO(employeeRepo.findByFirstName(firstName));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

		@Override
	public List<EmployeeDTO> getEmployeeByLastName(String lastName) {
		try {
			return employeeConverter.employeeEntityToDTO(employeeRepo.findByLastName(lastName));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public EmployeeDTO getEmployee(int id) {
		try {
			return employeeConverter.employeeEntityToDTO(employeeRepo.findById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResponseEntity<?> deleteEmployee(int id) {

		try {
			employeeRepo.deleteById(id);
			return ResponseEntity.ok("Delete successful");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public EmployeeDTO getEmployeeByEmployeeNumber(int employeeNumber) {
		try {
			return employeeConverter.employeeEntityToDTO(employeeRepo.findByEmployeeNumber(employeeNumber));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<EmployeeDTO> getEmployeeByStatus(String status) {
		try {
			return employeeConverter.employeeEntityToDTO(employeeRepo.findByStatus(status));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<EmployeeDTO> getEmployeeByPost(String post) {
		try {
			return employeeConverter.employeeEntityToDTO(employeeRepo.findByPost(post));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SkillDTO> getEmployeeSkills(int id) {
		try {
			Employee e= employeeRepo.findById(id);
			List<Skill> list=e.getSkills();
			return skillConverter.skillEntityToDTO(list);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CourseDTO> getEmployeeCourses(int id) {
		try {
			Employee e= employeeRepo.findById(id);
			List<Course> list=e.getCourses();
			return courseConverter.courseEntityToDTO(list);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

	@Override
	public ResponseEntity<?> updateEmployee(EmployeeDTO employeeDTO) {

		Employee employee=employeeRepo.findById(employeeDTO.getId());
		LOGGER.info("EMPLOYEE TO UPDATE IS:"+employee.toString());

		employee.setId(employeeDTO.getId());
		employee.setFirstName(employeeDTO.getFirstName());
		employee.setLastName(employeeDTO.getLastName());
		employee.setPhone(employeeDTO.getPhone());
		employee.setEmail(employeeDTO.getEmail());
		employee.setEmployeeNumber(employeeDTO.getEmployeeNumber());
		employee.setSalary(employeeDTO.getSalary());
		employee.setPost(employeeDTO.getPost());
		employee.setStatus(employeeDTO.getStatus());

		return ResponseEntity.ok("Updated Employee Successfully");
	}

	@Override
	public ResponseEntity<?> addEmployeeDetails(EmployeeDTO employeeDTO) {
		String name= SecurityContextHolder.getContext().getAuthentication().getName();
		UserEntity user=userEntityRepo.findByUserNameEntity(name);
		user.setEmployee(employeeConverter.employeeDtoToEntity(employeeDTO));
		userEntityRepo.save(user);
		return null;
	}


}
