package io.swagger.petstore.function;

import io.restassured.response.Response;
import io.swagger.petstore.common.Constant;
import io.swagger.petstore.common.HTTPRequestMethods;
import io.swagger.petstore.common.URIs;
import io.swagger.petstore.model.request.PetCreateRequest;
import io.swagger.petstore.util.HeaderUtil;
import io.swagger.petstore.util.JacksonUtil;
import io.swagger.petstore.util.RestUtil;

public class RequestGenerator {

    private RequestGenerator() {
    }

    public static void setExecutionEnvironment() {
        RestUtil.API_HOST = Constant.BASE_URI;
        RestUtil.BASE_PATH = Constant.BASE_PATH;
        RestUtil.PORT = Constant.PORT;
    }

    public static Response getPetById(String id) {
        setExecutionEnvironment();
        Response response;
        response = RestUtil.send(HeaderUtil.getHeader(), null, URIs.GET_PET_BY_ID.replace("{id}", id), HTTPRequestMethods.GET.value());
        return response;
    }

    public static Response createPet(PetCreateRequest petCreateRequest) {
        setExecutionEnvironment();
        String body = JacksonUtil.getAsString(petCreateRequest);
        Response response;
        response = RestUtil.send(HeaderUtil.getHeader(), body, URIs.POST_PET, HTTPRequestMethods.POST.value());
        return response;
    }
}
