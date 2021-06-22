package com.example.employeepayroll.rest;

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
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

class SkillControllerTest {

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

    public HttpHeaders getHeaders(String user, String pass) throws Exception {

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

        map= MockMvcUtil.convertJsonStringToObject(authorization,Map.class);

        token=(String) map.get("token");

        headers.setBearerAuth(token);

        return headers;

    }


    @Test
    void addEmployee() throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers=getHeaders("shi","123");

        RequestBuilder requestBuilder= MockMvcRequestBuilders
                                               .put("/api/skills/2/java")
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
}