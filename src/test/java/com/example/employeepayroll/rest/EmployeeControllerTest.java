package com.example.employeepayroll.rest;

import com.example.employeepayroll.Converter.EmployeeConverter;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.jwt.JwtUserDetailsService;
import com.example.employeepayroll.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(value = EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EmployeeConverter employeeConverter;

    @Mock
    private EmployeeService employeeService;





    EmployeeDTO e=new EmployeeDTO("shiva","harale","1234546","gmail",10531);

    EmployeeDTO e2=new EmployeeDTO("ak","harale","4356","yahoo",2354);


    String s="{\"firstName\":\"shivani\",\"lastName\":\"haral\",\"phone\":123456,\"email\":\"yahoomail\",\"employeeNumber\":1212}";

//    @Test
//    void createEmployee() throws Exception {
//
//        Mockito.when(employeeService.saveEmployee(Mockito.any(EmployeeDTO.class))).thenReturn(new ResponseEntity(e,HttpStatus.OK));
//
//        RequestBuilder requestBuilder= MockMvcRequestBuilders
//                                               .post("/employees")
//                .accept(MediaType.APPLICATION_JSON).content(s)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result=mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response=result.getResponse();
//
//        assertEquals(HttpStatus.CREATED.value(),response.getStatus());
//
//    }



    @Test
    void getEmployee() throws Exception {

        List<EmployeeDTO> list=new ArrayList<EmployeeDTO>();

        list.add(e);
        list.add(e2);

        Mockito.when(employeeService.employeeList()).thenReturn(list);

        RequestBuilder requestBuilder= MockMvcRequestBuilders
                                               .post("/employees")
                                               .accept(MediaType.APPLICATION_JSON).content(s)
                                               .contentType(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response=result.getResponse();

        assertEquals(HttpStatus.CREATED.value(),response.getStatus());

    }




}