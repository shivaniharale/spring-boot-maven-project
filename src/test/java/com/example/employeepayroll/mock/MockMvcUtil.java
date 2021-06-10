package com.example.employeepayroll.mock;

import com.example.employeepayroll.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


public class MockMvcUtil {

    public static void assertEqualsResponseDTO(ResponseDTO responseDTO, Integer statusCode, String status, String message) {
        assertEqualsResponseDTO(responseDTO, Optional.ofNullable(statusCode), Optional.ofNullable(message), Optional.ofNullable(status));
    }

    public static void assertEqualsResponseDTO(ResponseDTO responseDTO, Optional<Integer> statusCode, Optional<String> message, Optional<String> status) {
        ArrayList<Executable> executables = new ArrayList<>();

        statusCode.ifPresent(integer -> executables.add(() -> Assert.assertEquals(integer.intValue(), responseDTO.getStatusCode().intValue())));
        message.ifPresent(s -> executables.add(() -> Assert.assertEquals(s, responseDTO.getMessage())));
        status.ifPresent(s -> executables.add(() -> Assert.assertEquals(s, responseDTO.getStatus())));

        Assertions.assertAll(executables);
    }

    public static <T> T convertJsonStringToObject(String response,Class<?> type) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return (T) type.cast(objectMapper.readValue(response,type));
    }

    public static String generateAccessToken(TestRestTemplate testRestTemplate,int port,
    AuthenticationVM authenticationVM) throws URISyntaxException, JSONException {
        final String baseUrl = "http://localhost:" + port + "/api/employees";
        URI uri = new URI(baseUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.set("employee_payroll", "employee_payroll");

        HttpEntity<AuthenticationVM> request = new HttpEntity<AuthenticationVM>(authenticationVM, headers);
        ResponseEntity<String> entity = testRestTemplate.postForEntity(uri, request, String.class);
        return new ObjectMapper().convertValue(entity.getBody(), JSONObject.class).getJSONObject("data")
                       .getString("accessToken");
    }

    public static MvcResult post(MockMvc mvc, String url, MultiValueMap<String,String> param
    ,HttpHeaders httpHeaders,String mediaType,Object object) throws Exception {
        return getResultAction(mvc, MockMvcRequestBuilders.get(url),param,mediaType
                ,httpHeaders,object,null).andReturn();
    }


    public static MvcResult get(MockMvc mvc, String url, MultiValueMap<String,String> param
            ,HttpHeaders httpHeaders,String mediaType) throws Exception {
        return getResultAction(mvc, MockMvcRequestBuilders.get(url),param,mediaType
                ,httpHeaders,null,null).andReturn();
    }



    private static ResultActions getResultAction(MockMvc mvc, MockHttpServletRequestBuilder mockHttpServletRequestBuilder, MultiValueMap<String, String> param, String mediaType
    , HttpHeaders httpHeaders
    , Object body
    , ArrayList<ResultMatcher> resultMatchers) throws Exception {

        String content= new ObjectMapper().convertValue(body,String.class);

        ResultActions resultActions=mvc.perform(mockHttpServletRequestBuilder
                                                        .params(param)
                                                        .contentType(MediaType.APPLICATION_JSON)
                                                        .headers(httpHeaders)
                                                        .content(content))
                                            .andDo(print());
        return resultActions;
    }



}
