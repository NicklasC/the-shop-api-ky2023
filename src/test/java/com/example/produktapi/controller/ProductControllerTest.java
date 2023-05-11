package com.example.produktapi.controller;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

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
    void verify_getProductById()
    {
        given()
                .contentType("application/json")
       .when()
                .get("http://localhost:" +port+ "/products"+"/{id}", 1)
       .then()
                .body("id", equalTo(1));
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

    // Author: Camilla
    @Test
    void verify_getProductByTitle()
    {
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:"+port+"/products")
                .then()
                .body("title", hasItems("Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops"));
    }

    // Author: Camilla
    @Test(enabled = false)
    void test_deleteProductById()
    {
        given()
                .contentType("application/json")
                .when()
                .delete("http://localhost:" +port+"/products"+"/1")
                .then()
                .statusCode(405);
    }
}
