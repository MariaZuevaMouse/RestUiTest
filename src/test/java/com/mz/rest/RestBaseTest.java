package com.mz.rest;

import com.github.javafaker.Faker;
import com.mz.rest.entities.NewPet;
import com.mz.rest.entities.Status;
import com.mz.rest.utils.TestProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;

public class RestBaseTest {
    Faker faker = new Faker();
    static RequestSpecification specification;

    @BeforeAll
    static void beforeAll() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI = TestProperties.getTestDataProps().getProperty("baseUrl");
        specification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("api_key", "special-key").build();
    }

    protected NewPet getTestPet() {
        return new NewPet((int) (Math.random() * 1000),
                new NewPet.Category(Integer.valueOf((int) Math.random() * 100), "abc"),
                "myPat55", List.of(""),
                List.of(new NewPet.Tag(Integer.valueOf((int) Math.random() * 100), "def")),
                Status.PENDING.getStatus());
    }
}
