package com.example.cache_setup_test.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    private JsonUtils(){}

    private static final ObjectMapper OBJECT_MAPPER;

    static{
        OBJECT_MAPPER = new ObjectMapper();
    }

    public static <T> String serialize(T object) throws IOException {
        return OBJECT_MAPPER.writeValueAsString(object);
    }
    
}
