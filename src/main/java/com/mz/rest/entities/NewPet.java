package com.mz.rest.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@With
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NewPet {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photoUrls")
    private List<String> photoUrls = null;
    @JsonProperty("tags")
    private List<Tag> tags = null;
    @JsonProperty("status")
    private String status;

    @NoArgsConstructor
    @AllArgsConstructor
    @With
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Category {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @With
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Tag {
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;
    }
}
