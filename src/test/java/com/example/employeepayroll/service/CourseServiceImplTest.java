package com.example.employeepayroll.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


import com.example.employeepayroll.Converter.CourseConverter;
import com.example.employeepayroll.repository.CourseRepo;
import com.example.employeepayroll.dto.CourseDTO;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
class CourseServiceImplTest {

    @BeforeEach
    public void init(){
        initMocks(this);
    }

    @InjectMocks
    private CourseServiceImpl courseService;

    @Mock
    private CourseRepo courseRepo;

    @Mock
    private CourseConverter courseConverter;


    @Test
    void testGetEmployeeCourses() {
        List<CourseDTO> list=new ArrayList<>();
        CourseDTO one=new CourseDTO("java");
        CourseDTO two=new CourseDTO("spring");

        when(courseConverter.courseEntityToDTO(courseRepo.findAll())).thenReturn(list);

        List<CourseDTO> l2=courseService.getEmployeeCourses();

        Assert.assertEquals(list,l2);


    }

}