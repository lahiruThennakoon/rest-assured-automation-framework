package io.swagger.petstore.util;

import io.restassured.response.Response;

public class ResponseUtil {
    public ResponseUtil() {
    }

    public static int getResponseCode(Response response) {
        return RestUtil.getResponseCode(response);
    }
}

