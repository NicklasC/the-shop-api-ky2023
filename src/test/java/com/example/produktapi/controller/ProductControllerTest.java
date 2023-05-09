package com.example.produktapi.controller;

import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class ProductControllerTest {

    @LocalServerPort
    private Integer port;

    @Test
    void test_getAllProducts()

    {
        given()
                .contentType("application/json")
        .when()
               .get("http://localhost:" + port + "/products")
        .then()
                .statusCode(200);

    }

    @Test
    void test_getAllCategories()
    {
        given()
                .contentType("application/json")
        .when()
                .get("http://localhost:" +port+"/products"+"/categories")
        .then()
                .statusCode(200);

    }
    @Test
    void test_getProductById()
    {
        given()
                .contentType("application/json")
        .when()
                .get("http://localhost:" +port+"/products"+"/1")
        .then()
                .statusCode(200);

    }

    @Test
    void test_getProductByCategory()
    {
        given()
                .contentType("application/json")
        .when()
                .get("http://localhost:" +port+"/products"+"/categories"+"/electronics")
        .then()
                .statusCode(200);
    }


    @Test
    void verify_getProductsByDescription()
            //Author Daniel
    {
                 given()
                .contentType("application/json")
                .when()
                .get("http://localhost:" +port+"/products")
                .then()
                .body("description", hasItems("Fin väska me plats för dator"));

    }

}
