package com.demo.restassured.util;

import com.demo.restassured.model.request.RequestBase;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

public class JacksonUtil {
    public JacksonUtil() {
    }
    public static String getAsString(RequestBase requestBase) {
        return getAsString(requestBase, false);
    }

    public static final String getAsString(RequestBase body, boolean ignoreNull) {
        ObjectMapper mapper = new ObjectMapper();
        if (ignoreNull) {
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        }

        String jsonInString = "";

        try {
            jsonInString = mapper.writeValueAsString(body);
        } catch (JsonProcessingException var5) {
            jsonInString = Arrays.toString(var5.getStackTrace());
        }

        return jsonInString;
    }

}
