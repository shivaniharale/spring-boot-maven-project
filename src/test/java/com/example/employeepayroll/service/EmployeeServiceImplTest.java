package com.example.employeepayroll.service;

import com.example.employeepayroll.Converter.EmployeeConverter;
import com.example.employeepayroll.repository.EmployeeRepo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepo employeeRepo;

    @Mock
    EmployeeConverter employeeConverter;

    @Test
    void employeeListTest() {


    }
}