package com.example.employeepayroll.service;

import com.example.employeepayroll.Converter.CourseConverter;
import com.example.employeepayroll.repository.CourseRepo;
import com.example.employeepayroll.repository.EmployeeRepo;
import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CourseConverter courseConverter;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<CourseDTO> getEmployeeCourses(int id) {

        return courseConverter.courseEntityToDTO(employeeRepo.findById(id).getCourses());

    }

    @Override
    public List<CourseDTO> getEmployeeCourses() {
        return courseConverter.courseEntityToDTO(courseRepo.findAll());
    }

    @Override
    public ResponseEntity<?> saveCourse(int id, CourseDTO courseDTO) {
        Employee employee= employeeRepo.findById(id);
        employee.addCourse(courseConverter.courseDtoToEntity(courseDTO));
        return ResponseEntity.ok("Saved Successfully");
    }


}
