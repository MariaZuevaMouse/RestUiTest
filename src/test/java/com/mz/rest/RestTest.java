package com.mz.rest;

import com.mz.rest.entities.NewPet;
import com.mz.rest.entities.Status;
import com.mz.rest.utils.Constants;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.mz.rest.utils.Constants.GET_PETS_BY_STATUS;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

class RestTest extends RestBaseTest {
    NewPet testPet;

    @BeforeEach
    void setUp() {
        testPet = getTestPet();
    }

    @Test
    @SneakyThrows
    void addNewPetTest() {
        given().spec(specification)
                .urlEncodingEnabled(false)
                .log().all()
                .when()
                .body(testPet)
                .post(Constants.NEW_PET)
                .prettyPeek()
                .then()
                .statusCode(200);
        NewPet[] pets = given().spec(specification)
                .queryParam("status", testPet.getStatus())
                .get(GET_PETS_BY_STATUS).prettyPeek().then().log().all()
                .extract().body().as(NewPet[].class);

        assertThat(pets)
                .as("Check test pet '{}' is added to the server")
                .contains(testPet);
    }

    @Test
    void deletePetTest(){
        given().spec(specification)
                .when()
                .delete(Constants.DELETE_PET, testPet.getId())
                .then().statusCode(404);
        NewPet[] pets = given().spec(specification)
                .queryParam("status", testPet.getStatus())
                .get(GET_PETS_BY_STATUS).prettyPeek().then().log().all()
                .extract().body().as(NewPet[].class);

        assertThat(pets)
                .as("Check test pet '{}' is removed from server")
                .doesNotContain(testPet);
    }
}