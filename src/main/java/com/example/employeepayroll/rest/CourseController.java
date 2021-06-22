package com.example.employeepayroll.rest;

import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/courses",method = RequestMethod.GET)
    public List<CourseDTO> getCourses(){
        return courseService.getEmployeeCourses();
    }

    @RequestMapping(value = "/saveCourses/{id}",method = RequestMethod.POST)
    public ResponseEntity<?> saveCourses(@PathVariable int id,@RequestBody List<CourseDTO> courseList){

        return courseService.saveCourses(id,courseList);
    }

    @PutMapping("/courses/{existingCourse}/{replacementCourse}")
    public ResponseEntity<?> updateEmployee(@PathVariable String existingCourse
            ,@PathVariable String replacementCourse) {

        return ResponseEntity.ok(courseService.updateCourse(existingCourse,replacementCourse));
    }

}
