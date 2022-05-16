package com.demo.restassured.util;


import java.util.HashMap;
import java.util.Map;

public class HeaderUtil {

    public HeaderUtil() {
    }

    public static Map<String, String> getHeader() {
        Map<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        return headers;
    }

}
