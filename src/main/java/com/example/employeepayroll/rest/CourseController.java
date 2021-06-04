package com.example.employeepayroll.rest;

import com.example.employeepayroll.dto.CourseDTO;
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




//    @RequestMapping(value = "/courses/{}",method = RequestMethod.GET)
//    public List<CourseDTO> getEmployeeCourses(@PathVariable String firstName,@PathVariable String lastName){
//
//       return courseService.getEmployeeCourses(firstName,lastName);
//
//    }

    @PostMapping("/courses/{id}")
    public ResponseEntity<String> saveCourseList(@PathVariable int id,@RequestBody CourseDTO newCourse){
        courseService.saveCourse(newCourse);

        return ResponseEntity.status(HttpStatus.OK).body("Course Saved Successfully");

    }


}
