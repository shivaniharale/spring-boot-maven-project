package com.example.employeepayroll.rest;

import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.mock.MockForTest;
import com.example.employeepayroll.mock.MockMvcUtil;
import com.example.employeepayroll.service.EmployeeService;
import com.google.gson.Gson;
import liquibase.pro.packaged.A;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.http.server.reactive.MockServerHttpResponse;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(value = EmployeeController.class)
@WithMockUser
class EmployeeControllerTest {

    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private String accessToken;

    @LocalServerPort
    private int port;

    Employee employee;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeService employeeService;


//    @BeforeEach
//    public void init() throws Exception{
//        createDBTables();
//        accessToken= MockMvcUtil.generateAccessToken(testRestTemplate,port,MockForTest.generateAuthenticationVM());
//    }


    String s="{\"firstName\":\"shivani\",\"lastName\":\"harale\",\"phone\":\"1234567898\",\"email\":" +
                     "\"gmail\",\"employeeNumber\":10531}";

    @Test
    void createEmployee() throws Exception {

        Employee e=new Employee("shivani","harale","1234567898","gmail",10531);

        Gson gson=new Gson();
        String json=gson.toJson(e);

        log.info("JSON GSON"+json);

        Mockito.when(employeeService.saveEmployee(any(EmployeeDTO.class))).thenReturn(new ResponseEntity(HttpStatus.OK));

        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .post("/api/employees")
                .accept(MediaType.APPLICATION_JSON)
                .content(s)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc
                .perform(requestBuilder)
                .andReturn();

        MockHttpServletResponse response=result.getResponse();
        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
    }

    @Test
    void getEmployeeByFirstName() throws Exception {

        EmployeeDTO e=new EmployeeDTO("shivani","harale","1234567898","gmail",10531);
        EmployeeDTO e2=new EmployeeDTO("shivani","naik","23451234","yahoo",1232);

        List<EmployeeDTO> list=new ArrayList<EmployeeDTO>();
        list.add(e);
        list.add(e2);

        Mockito.when(employeeService.getEmployeeByFirstName(any())).thenReturn(MockForTest.getMockEmployeeDtoList());
        String firstName="shivani";

        RequestBuilder requestBuilder=MockMvcRequestBuilders
                .get("/api/employees")
                .param("firstName", firstName)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc
                .perform(requestBuilder)
                .andReturn();

        MockHttpServletResponse response=result.getResponse();

        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());

        Assert.assertEquals(list,response.getContentAsString());

    }

    @Test
    void getEmployeeList() throws Exception {
        Mockito.when(employeeService.employeeList()).thenReturn(MockForTest.getMockEmployeeDtoList());

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/employees"))
             //   .andExpect(HttpStatus.OK.value())
                .andExpect(content().json(("[]")));

    }
}