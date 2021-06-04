package com.example.employeepayroll.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


import com.example.employeepayroll.dao.CourseDAO;
import com.example.employeepayroll.entity.Course;
import liquibase.pro.packaged.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class CourseServiceImplTest {

    @InjectMocks
    CourseServiceImpl courseService;

    @Mock
    CourseDAO courseDAO;

    @BeforeEach
    void setUp() {
        List<Course> list=new ArrayList<>();
        Course one=new Course(1,"java");
        Course two=new Course(2,"spring");
        list.add(one);
        list.add(two);
    }

    @Test
    void saveOrUpdateCourseList() {

        Course one=new Course(5,"flutter");
        when(courseDAO.save(one)).thenReturn(one);
        assertThat(one.getId()).isGreaterThan(0);


    }

    @Test
    void getEmployeeCourses() {


    }

    @Test
    void testGetEmployeeCourses() {

        List<Course> list=new ArrayList<>();
        Course one=new Course(1,"java");
        Course two=new Course(2,"spring");
        list.add(one);
        list.add(two);

        when(courseDAO.findAll()).thenReturn(list);
        assertNotNull(list);
        assertEquals(list,courseDAO.findAll());

    }


}