package io.swagger.petstore.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"id", "name"})
@Getter
@Setter
@Builder
public class PetTag extends RequestBase {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;

}
