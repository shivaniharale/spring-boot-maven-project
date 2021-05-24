package com.example.employeepayroll.service;

import java.util.List;

import com.example.employeepayroll.dao.CourseDAO;
import com.example.employeepayroll.entity.Course;
import com.example.employeepayroll.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeepayroll.Converter.CourseConverter;
import com.example.employeepayroll.Converter.EmployeeConverter;
import com.example.employeepayroll.dao.EmployeeDAO;
import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.dto.EmployeeDTO;

@Service
@Transactional
public class ServiceInterfaceImpl implements ServiceInterface {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private EmployeeConverter employeeConverter;

	@Autowired
	private CourseConverter courseConverter;

	@Autowired
	private CourseDAO courseDAO;



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
	public ResponseEntity<String> saveOrUpdateEmployee(EmployeeDTO employeeDTO) {

		try {
			employeeDAO.save(employeeConverter.employeeDtoToEntity(employeeDTO));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return (ResponseEntity<String>) ResponseEntity.ok();

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
	public ResponseEntity<String> deleteEmployee(int id) {

		try {
			employeeDAO.deleteById(id);

		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
		return (ResponseEntity<String>) ResponseEntity.ok();


	}


	@Override
	public ResponseEntity<String> saveOrUpdateCourseList(CourseDTO newCourse) {

		try {
			courseDAO.save(courseConverter.courseDtoToEntity(newCourse));


		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return (ResponseEntity<String>) ResponseEntity.ok();

	}

	@Override
	public List<CourseDTO> getEmployeeCourses(int id) {

		try {
			Employee e=employeeDAO.findById(id);

			List<Course> list=e.getCourses();

			return courseConverter.courseEntityToDTO(list);

		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}

	}

	@Override
	public List<CourseDTO> getEmployeeCourses() {
		try {
			return courseConverter.courseEntityToDTO(courseDAO.findAll());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<EmployeeDTO> getEmployeeByFirstName(String firstName) {

		try {
			return employeeConverter.employeeEntityToDTO(employeeDAO.findByfirstName(firstName));
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
	public List<EmployeeDTO> getEmployeeByLastName(String lastName) {
		try {
			return employeeConverter.employeeEntityToDTO(employeeDAO.findByLastName(lastName));
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


}
