package com.example.produktapi.exception;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class EntityNotFoundExceptionTest {
    //@LocalServerPort
    @LocalServerPort
    private Integer port;

    // Author: Nicklas
    @Test
    void test_EntityNotFound() {
        String expectedProductId = "555";
        String expectedResponse = "Produkt med id " + expectedProductId + " hittades inte";
        Response response = given()
                .contentType("application/json")
                .when()
                .get("https://team-2-shop.herokuapp.com/products" + "/" + expectedProductId)
                .then()
                .extract().
                response();
        Assertions.assertEquals(expectedResponse, response.asString());
        Assertions.assertEquals(404, response.getStatusCode());
    }

    // Author: Nicklas
    @Test
    void test_BadRequest() {
        Response response = given()
                .contentType("application/json")
                .when()
                .get("https://team-2-shop.herokuapp.com/products" + "/ghghh")
                .then()
                .extract().
                response();

        Assertions.assertEquals(400, response.getStatusCode());
    }
}
