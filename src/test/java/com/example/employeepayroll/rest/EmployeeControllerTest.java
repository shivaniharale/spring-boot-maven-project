package com.example.employeepayroll.rest;


import com.example.employeepayroll.dto.EmployeeDTO;

import com.example.employeepayroll.jwt.JwtRequest;
import com.example.employeepayroll.mock.MockMvcUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class EmployeeControllerTest {

    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void init() throws Exception {

    }

    public HttpHeaders getHeaders(String user,String pass) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        Map<String,Object> map=new HashMap<>();
        String jwtRequestString,authorization,token;
        JwtRequest jwtRequest=new JwtRequest();

        jwtRequest.setUserName(user);
        jwtRequest.setPassword(pass);

        jwtRequestString=objectMapper.writeValueAsString(jwtRequest);

        RequestBuilder requestBuilder= MockMvcRequestBuilders
                                   .post("/authenticate")
                                   .content(jwtRequestString)
                                   .accept(MediaType.APPLICATION_JSON)
                                   .contentType(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc
                                  .perform(requestBuilder)
                                  .andExpect(status().isOk())
                                  .andReturn();

        authorization=result.getResponse().getContentAsString();

        map=MockMvcUtil.convertJsonStringToObject(authorization,Map.class);

        token=(String) map.get("token");

        headers.setBearerAuth(token);

        return headers;

    }

    @Test
    void createEmployee() throws Exception {
        EmployeeDTO e=new EmployeeDTO(5,"poo","patil","123425","orkut",999);
        EmployeeDTO e2=new EmployeeDTO(5,"sonu","patil","666384","@coditas",94369);

//        JwtRequest jwtRequest=new JwtRequest();
//        jwtRequest.setUserName("shi");
//        jwtRequest.setPassword("123");
//
//        String jr=objectMapper.writeValueAsString(jwtRequest);
//
//        RequestBuilder rb= MockMvcRequestBuilders
//                                               .post("/authenticate")
//                                               .content(jr)
//                                               .accept(MediaType.APPLICATION_JSON)
//                                               .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result1=mockMvc
//                                 .perform(rb)
//                                 .andExpect(status().isOk())
//                                 .andReturn();
//
//        log.info("RECEIVED TOKEN:"+result1.getResponse().toString());
//
//
//        String auth=result1.getResponse().getContentAsString();
//
//
//        Map<String,Object> map=new HashMap<>();
//
//        map=MockMvcUtil.convertJsonStringToObject(auth,Map.class);
//
//        String token=(String) map.get("token");

        HttpHeaders headers = new HttpHeaders();
        headers=getHeaders("shi","123");

        List<EmployeeDTO> list=new ArrayList<EmployeeDTO>();
        list.add(e);
        list.add(e2);

        String inputContent=objectMapper.writeValueAsString(e);

        RequestBuilder requestBuilder= MockMvcRequestBuilders
                                               .post("/api/employees")
                                               .content(inputContent)
                                               .headers(headers)
                                               .accept(MediaType.APPLICATION_JSON)
                                               .contentType(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc
                                 .perform(requestBuilder)
                                 .andExpect(status().isOk())
                                 .andReturn();

        MockHttpServletResponse response=result.getResponse();

        Assert.assertEquals(200,result.getResponse().getStatus());
    }

    @Test
    void getEmployeeByFirstName() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers=getHeaders("shi","123");

//        String firstName="lata";

        RequestBuilder requestBuilder= MockMvcRequestBuilders
                .get("/api/firstName/lata")
//                .param("firstName", firstName)
                .headers(headers)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        MockHttpServletResponse response=result.getResponse();

        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());

    }

    @Test
    void getEmployeeList() throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers=getHeaders("shi","123");

        RequestBuilder requestBuilder= MockMvcRequestBuilders
                                               .get("/api/employees")
                                               .headers(headers)
                                               .contentType(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc
                                 .perform(requestBuilder)
                                 .andReturn();

        MockHttpServletResponse response=result.getResponse();

        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());

    }


}