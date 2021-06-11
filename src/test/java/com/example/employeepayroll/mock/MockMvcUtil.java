package com.example.employeepayroll.mock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class MockMvcUtil {

    public static <T> T convertJsonStringToObject(String response,Class<?> type) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return (T) type.cast(objectMapper.readValue(response,type));
    }


}
