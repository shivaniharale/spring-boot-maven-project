package com.example.employeepayroll.rest;

import com.example.employeepayroll.dto.CourseDTO;
import com.example.employeepayroll.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private ServiceInterface service;


    Logger logger= Logger.getLogger(getClass().getName());


    @RequestMapping(value = "/courseslist",method = RequestMethod.GET)
    public List<CourseDTO> getCourses(){

        logger.info("INSIDE COURSELIST METHOD");
        return service.getEmployeeCourses();
    }


    @RequestMapping(value = "/courseslist/{id}",method = RequestMethod.GET)
    public List<CourseDTO> getEmployeeCourses(@PathVariable int id){

        return service.getEmployeeCourses(id);
    }


    @PostMapping("/courseslist/{id}")
    public ResponseEntity<String> saveCourseList(@PathVariable int id,@RequestBody CourseDTO newCourse){

        service.saveOrUpdateCourseList(newCourse);

        return ResponseEntity.status(HttpStatus.OK).body("Course Saved Successfully");

    }

    @PutMapping("/courseslist")
    public ResponseEntity<String> updateCourseList(@RequestBody CourseDTO newCourse){

        service.saveOrUpdateCourseList(newCourse);

        return ResponseEntity.status(HttpStatus.OK).body("Course Updated Successfully");

    }

}
