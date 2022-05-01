package io.swagger.petstore.util;

import java.util.HashMap;

public class HeaderUtil {

    public HeaderUtil() {
    }

    public static HashMap<String, String> getHeader() {
        HashMap<String, String> headers = new HashMap();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        return headers;
    }

}
