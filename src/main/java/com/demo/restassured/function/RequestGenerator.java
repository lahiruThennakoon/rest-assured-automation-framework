package com.demo.restassured.function;

import com.demo.restassured.util.HeaderUtil;
import io.restassured.response.Response;
import com.demo.restassured.common.HTTPRequestMethods;
import com.demo.restassured.common.URIs;
import com.demo.restassured.model.request.PetCreateRequest;
import com.demo.restassured.util.JacksonUtil;
import com.demo.restassured.util.RestUtil;

public class RequestGenerator {

    private RequestGenerator() {
    }


    public static Response getPetById(String id) {
        Response response;
        response = RestUtil.send(HeaderUtil.getHeader(), null, URIs.GET_PET_BY_ID.replace("{id}", id), HTTPRequestMethods.GET.value(),null);
        return response;
    }

    public static Response createPet(PetCreateRequest petCreateRequest) {
        String body = JacksonUtil.getAsString(petCreateRequest);
        Response response;
        response = RestUtil.send(HeaderUtil.getHeader(), body, URIs.POST_PET, HTTPRequestMethods.POST.value(),null);
        return response;
    }
}
