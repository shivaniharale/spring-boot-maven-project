package com.example.employeepayroll.rest;

import com.example.employeepayroll.Converter.EmployeeConverter;
import com.example.employeepayroll.dao.EmployeeDAO;
import com.example.employeepayroll.dto.EmployeeDTO;
import com.example.employeepayroll.entity.Address;
import com.example.employeepayroll.entity.Employee;
import com.example.employeepayroll.mock.MockForTest;
import com.example.employeepayroll.mock.MockMvcUtil;
import com.example.employeepayroll.mock.ResponseDTO;
import com.example.employeepayroll.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import liquibase.pro.packaged.T;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class EmployeeControllerTest {

    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private String accessToken;
    Employee employee;
    Address address;

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeConverter employeeConverter;

    private TestRestTemplate testRestTemplate=new TestRestTemplate();

    @BeforeEach
    public void init() throws Exception {
        createDBTables();
        accessToken= MockMvcUtil.generateAccessToken(testRestTemplate,port
                ,MockForTest.generateAuthenticationVM());
    }

    public void createDBTables() {
        employee=MockForTest.getEmployee();
        address=MockForTest.getAddress();
        employeeDAO.save(employee);

    }
    @AfterEach
    public void resetDb() {
        MockForTest.clearDB(jdbcTemplate);
    }

    private HttpHeaders generateHttpHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(accessToken);
        return httpHeaders;
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    @Test
    void createEmployee() throws Exception {

//        String expected = "{\"firstName\":\"shivani\",\"lastName\":\"harale\",\"phone\":\"1234567898\",\"email\":" +
//                           "\"gmail\",\"employeeNumber\":10531}";
//
//        Employee e = new Employee(5,"sh", "sh", "43434523521", "shivani@rediff", 14351);
//        employeeDAO.save(e);
//
//        log.info("HELLO");
//
//        Gson gson = new Gson();
//        String json = gson.toJson(e);
//
//        log.info("JSON GSON" + json);
//
//        Mockito.when(employeeDAO.save(any())).thenReturn(new ResponseEntity(HttpStatus.OK)  );
//        Mockito.when(employeeService.saveEmployee(any())).thenReturn(new ResponseEntity(HttpStatus.OK));
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                                                .post("http://localhost:8080/api/employees")
//                                                .accept(MediaType.APPLICATION_JSON)
//                                                .content(json)
//                                                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder)
//                                   .andReturn();
//        log.info("HERE $$$ ");
//
//        MockHttpServletResponse response = result.getResponse();
//        Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void getEmployeeByFirstName() throws Exception {

//        EmployeeDTO e=new EmployeeDTO("shivani","harale","1234567898","gmail",10531);
//        EmployeeDTO e2=new EmployeeDTO("shivani","naik","23451234","yahoo",1232);
//
//        List<EmployeeDTO> list=new ArrayList<EmployeeDTO>();
//        list.add(e);
//        list.add(e2);
//
//        Mockito.when(employeeService.getEmployeeByFirstName(any())).thenReturn(MockForTest.getMockEmployeeDtoList());
//        String firstName="shivani";
//
//        RequestBuilder requestBuilder= MockMvcRequestBuilders
//                .get("/api/employees")
//                .param("firstName", firstName)
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result=mockMvc
//                .perform(requestBuilder)
//                .andReturn();
//
//        MockHttpServletResponse response=result.getResponse();
//
//        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
//
//        Assert.assertEquals(list,response.getContentAsString());

    }

    @Test
    void getEmployeeList() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        HttpHeaders httpHeaders = generateHttpHeader();
        String responseBody=MockMvcUtil.get(mockMvc,"/api/employees",params,httpHeaders,MediaType.APPLICATION_JSON_VALUE).getResponse().getContentAsString();

        ResponseDTO responseDTO=MockMvcUtil.convertJsonStringToObject(responseBody,ResponseDTO.class);
        MockMvcUtil.assertEqualsResponseDTO(responseDTO, 200,"SUCCESS","EMPLOYEE_LIST_FETCHED_SUCCESSFULLY");
    }


}