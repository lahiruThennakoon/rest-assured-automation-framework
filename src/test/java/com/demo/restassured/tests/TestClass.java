package com.demo.restassured.tests;

import com.demo.restassured.TestBase;
import com.demo.restassured.common.TestConstants;
import com.demo.restassured.function.RequestGenerator;
import com.demo.restassured.messages.AssertionConstants;
import com.demo.restassured.model.request.PetCategory;
import com.demo.restassured.model.request.PetCreateRequest;
import com.demo.restassured.model.request.PetTag;
import com.demo.restassured.model.response.PetPostResponse;
import com.demo.restassured.util.ResponseUtil;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestClass extends TestBase {

    @Test(priority = 0)
    public void verifyPetCreation() {
        PetTag petTag = PetTag.builder().id(TestConstants.PET_TAG_ID).name(TestConstants.PET_TAG_NAME).build();
        List<PetTag> petTagList = new ArrayList<>();
        petTagList.add(petTag);
        PetCategory petCategory = PetCategory.builder().id(TestConstants.PET_CATEGORY_ID).name(TestConstants.PET_CATEGORY_NAME).build();
        List<String> photoUrlsList = new ArrayList<>();
        photoUrlsList.add(TestConstants.PET_URL);
        PetCreateRequest petCreateRequest = PetCreateRequest.builder().category(petCategory).id(TestConstants.PET_ID).
                name(TestConstants.PET_NAME).photoUrls(photoUrlsList).status(TestConstants.PET_STATUS).tags(petTagList).build();
        Response response = RequestGenerator.createPet(petCreateRequest);
        PetPostResponse petPostResponse = response.as(PetPostResponse.class);
        softAssert.assertEquals(ResponseUtil.getResponseCode(response),
                200, AssertionConstants.STATUS_CODE_DOES_NOT_MATCH);
        softAssert.assertEquals(petPostResponse.getId(), Integer.valueOf(TestConstants.PET_ID));
        softAssert.assertEquals(petPostResponse.getCategory().getName(), TestConstants.PET_CATEGORY_NAME);
        softAssert.assertAll();
    }

    @Test
    public void verifyGetPetInfoByProvidingPetId() {
        Response response = RequestGenerator.getPetById(TestConstants.PET_ID);
        PetPostResponse petPostResponse = response.as(PetPostResponse.class);
        softAssert.assertEquals(ResponseUtil.getResponseCode(response),
                200, AssertionConstants.STATUS_CODE_DOES_NOT_MATCH);
        softAssert.assertEquals(petPostResponse.getId(), Integer.valueOf(TestConstants.PET_ID));
        softAssert.assertEquals(petPostResponse.getName(), TestConstants.PET_NAME);
        softAssert.assertAll();
    }

}
