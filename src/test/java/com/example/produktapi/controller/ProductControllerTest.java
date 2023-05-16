package com.example.produktapi.controller;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class ProductControllerTest {

    @LocalServerPort
    private Integer port;

    // Author: Priyanka
    @Test
    void test_getAllProducts() {
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:" + port + "/products")
                .then()
                .statusCode(200)
                .body("$", Matchers.hasSize(20));
    }

    // Author: Priyanka
    @Test
    void test_getAllCategories() {
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:" + port + "/products" + "/categories")
                .then()
                .statusCode(200)
                .body("$", Matchers.hasSize(4));
    }

    //Author: Nicklas
    @Test
    void test_getAllCategoriesList() {
        String expectedResponse = "[\"electronics\",\"jewelery\",\"men's clothing\",\"women's clothing\"]";
        Response response = given()
                .contentType("application/json")
                .when()
                .get("http://localhost:" + port + "/products" + "/categories")
                .then()
                .extract().
                response();
        Assertions.assertEquals(expectedResponse, response.asString());
    }

    // Author: Priyanka
    @Test
    void test_getProductById() {
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:" + port + "/products" + "/5")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(5))
                .body("title", Matchers.equalTo("John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet"))
                .body("price", Matchers.equalTo(695.0F))
                .body("category", Matchers.equalTo("jewelery"))
                .body("description", Matchers.equalTo("Silver drakens återkomst. Ett måste om man vill ha den!"))
                .body("image", Matchers.equalTo("https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg"));
    }

    // Author: Jim
    @Test
    void verify_getProductById()
    {
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:" + port + "/products" + "/{id}", 1)
                .then()
                .body("id", equalTo(1));
    }

    // Author: Priyanka
    @Test
    void test_getProductByCategory() {
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:" + port + "/products" + "/categories" + "/electronics")
                .then()
                .statusCode(200)
                .body("$", Matchers.hasSize(6));
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

    // Author: Daniel
    @Test
    void getProductsByDescription() {
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:" + port + "/products")
                .then()
                .body("description", hasItems("Fin väska me plats för dator"));
    }

}
