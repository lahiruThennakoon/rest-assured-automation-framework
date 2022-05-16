package com.demo.restassured.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Builder
public class PetCreateRequest extends RequestBase {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({"id", "category", "name", "photoUrls", "tags", "status"})

    @JsonProperty("id")
    private String id;
    @JsonProperty("category")
    private PetCategory category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photoUrls")
    private List<String> photoUrls = null;
    @JsonProperty("tags")
    private List<PetTag> tags = null;
    @JsonProperty("status")
    private String status;
}
