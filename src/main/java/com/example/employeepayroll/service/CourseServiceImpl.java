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
    public List<CourseDTO> getEmployeeCourses() {

        try {
            return courseConverter.courseEntityToDTO(courseRepo.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseEntity<?> saveCourses(int id, List<CourseDTO> courseList) {
        try {
            Employee employee= employeeRepo.findById(id);
            for (CourseDTO c:courseList)
            employee.addCourse(courseConverter.courseDtoToEntity(c));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("Saved Successfully");
    }

}
