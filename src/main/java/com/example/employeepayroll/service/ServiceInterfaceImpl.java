package com.example.employeepayroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.employeepayroll.Converter.CourseConverter;
import com.example.employeepayroll.Converter.DetailsConverter;
import com.example.employeepayroll.Converter.EmployeeConverter;
import com.example.employeepayroll.dao.CourseJPARepo;
import com.example.employeepayroll.dao.DetailsDAO;
import com.example.employeepayroll.dao.EmployeeDAO;
import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.dto.DetailsDTO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.entity.Course;
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
	private EmployeeConverter employeeConverter;
	
	@Autowired
	private CourseConverter courseConverter;
	
	@Autowired
	private DetailsConverter detailsConverter;
	
	@Autowired
	private CourseJPARepo courseJPARepo;
	
	
	
	@Override
	public List<EmployeeDTO> employeeList() {
			
		List<Employee> list=employeeDAO.employeeList();
		
		return employeeConverter.employeeEntityToDTO(list);
		
	}

	@Override
	public void saveOrUpdateEmployee(EmployeeDTO employeeDTO) {
		
		Employee employee=employeeConverter.employeeDtoToEntity(employeeDTO);
		
		employeeDAO.saveOrUpdateEmployee(employee);
		
	}

	@Override
	public EmployeeDTO getEmployee(int id) {
		
		
			
		Employee employee=employeeDAO.getEmployee(id);
		return employeeConverter.employeeEntityToDTO(employee);

		}

	@Override
	public void deleteEmployee(int id) {

		employeeDAO.deleteEmployee(id);
	
	}

	@Override
	public List<DetailsDTO> detailsList() {
		
		List<Details> list=detailsDAO.detailsList();
		
		return detailsConverter.detailsEntityToDTO(list);
		
	}

	@Override
	public void saveOrUpdateDetails(DetailsDTO detailsDTO) {

		Details details=detailsConverter.detailsDtoToEntity(detailsDTO);
		
		detailsDAO.saveOrUpdateDetails(details);
		
	}

	@Override
	public DetailsDTO getDetails(int id) {
		Details details=detailsDAO.getDetails(id);
		return detailsConverter.detailsEntityToDTO(details);
	}

	@Override
	public List<CourseDTO> getCourses(int id) {
		Employee employee=employeeDAO.getEmployee(id);
		
		List<Course> courses=employee.getCourses();
				
		return courseConverter.courseEntityToDTO(courses);
	}


	@Override
	public void saveOrUpdateCourseList(CourseDTO newCourse) {
		
		Course course=courseConverter.courseDtoToEntity(newCourse);
		
		courseJPARepo.save(course);
	}

	
}
