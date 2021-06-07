package com.example.employeepayroll.service;

import com.example.employeepayroll.Converter.CourseConverter;
import com.example.employeepayroll.Converter.SkillConverter;
import com.example.employeepayroll.dao.CourseDAO;
import com.example.employeepayroll.dao.EmployeeDAO;
import com.example.employeepayroll.dao.SkillDAO;
import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.dto.SkillDTO;
import com.example.employeepayroll.entity.Course;
import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private CourseConverter courseConverter;

    @Autowired
    private CourseDAO courseDAO;

    @Override
    public List<CourseDTO> getEmployeeCourses(int id) {

        return courseConverter.courseEntityToDTO(employeeDAO.findById(id).getCourses());

    }

    @Override
    public List<CourseDTO> getEmployeeCourses() {
        return courseConverter.courseEntityToDTO(courseDAO.findAll());
    }


}
