package io.swagger.petstore.util;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RestUtil {

    public static String API_HOST;
    public static String BASE_PATH;
    public static int PORT = 0;


    public static Response send(Map<String, String> headers, String bodyString, String uri, String requestMethod, Map<String, String> queryParameters) {
        RestAssured.baseURI = API_HOST;
        RestAssured.basePath = BASE_PATH;
        if (PORT != 0) {
            RestAssured.port = PORT;
        }

        LoggerUtil.logINFO("\n\nHEADERS\n" + headers + "\n*********\n\n");
        LoggerUtil.logINFO("\n\nREQUEST_URL\n" + RestAssured.baseURI + RestAssured.basePath + "/" + uri + "\n*********\n\n");
        RequestSpecification requestSpecification = getRequestSpec(headers, bodyString);
        LoggerUtil.logINFO("\n\nREQUEST_BODY\n" + bodyString + "\n*********\n\n");
        requestSpecification = RestAssured.given().spec(requestSpecification);
        String theUri = setQueryParameters(uri, queryParameters);
        Response response = execute(requestMethod, requestSpecification, theUri);
        LoggerUtil.logINFO("\n\nRESPONSE\n" + response.getBody().asString() + "\n*********\n\n");
        LoggerUtil.logINFO("\n\nRESPONSE_STATUS_CODE\n" + response.getStatusCode() + "\n*********\n\n");
        return response;
    }


    public static Response execute(String reqMethod, RequestSpecification requestSpec, String uri) {
        RequestSpecification requestSpecification = RestAssured.given(requestSpec);
        Response response = null;
        if ("GET".equalsIgnoreCase(reqMethod)) {
            response = (Response) requestSpecification.expect().when().get(uri);
        }

        if ("POST".equalsIgnoreCase(reqMethod)) {
            response = (Response) requestSpecification.expect().when().post(uri);
        }

        if ("PUT".equalsIgnoreCase(reqMethod)) {
            response = (Response) requestSpecification.expect().when().put(uri);
        }

        if ("DELETE".equalsIgnoreCase(reqMethod)) {
            response = (Response) requestSpecification.expect().when().delete(uri);
        }

        if ("PATCH".equalsIgnoreCase(reqMethod)) {
            response = (Response) requestSpecification.expect().when().patch(uri);
        }

        return response != null ? response : null;
    }

    public static RequestSpecification getRequestSpec(Map<String, String> headers, String body) {
        RequestSpecBuilder reqSpecBuilder = new RequestSpecBuilder();
        if (headers != null) {
            reqSpecBuilder.addHeaders(headers);
        }

        if (body != null && body.length() > 0) {
            reqSpecBuilder.setBody(body);
        }
        return reqSpecBuilder.build();
    }

    public static String setQueryParameters(String url, Map<String, String> queryParameters) {
        if (queryParameters != null && !queryParameters.isEmpty()) {
            String newUrl = url.concat("?");

            String key;
            String value;
            for (Iterator var3 = queryParameters.entrySet().iterator(); var3.hasNext(); newUrl = newUrl.concat(key).concat("=").concat(value).concat("&")) {
                Map.Entry<String, String> entry = (Map.Entry) var3.next();
                key = (String) entry.getKey();
                value = (String) entry.getValue();
            }

            return newUrl.substring(0, newUrl.length() - 1);
        } else {
            return url;
        }
    }


    public static Response send(HashMap<String, String> headers, String body, String uri, String requestMethod) {
        return send(headers, body, uri, requestMethod, (Map) null);
    }

    public static int getResponseCode(Response response) {
        return response.getStatusCode();
    }

}
