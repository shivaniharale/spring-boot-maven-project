package com.example.employeepayroll.service;

import com.example.employeepayroll.Converter.EmployeeConverter;
import com.example.employeepayroll.dao.EmployeeDAO;

import com.example.employeepayroll.entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeDAO employeeDAO;

    @Mock
    EmployeeConverter employeeConverter;

    @Test
    void employeeListTest() {


    }
}