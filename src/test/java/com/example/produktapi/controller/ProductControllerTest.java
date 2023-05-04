package com.example.produktapi.controller;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
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
    void test_getAllProducts() {
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:" + port + "/products")
                .then()
                .statusCode(200);

    }

    @Test
    void test_getAllCategories() {
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:" + port + "/products" + "/categories")
                .then()
                .statusCode(200);

    }

    @Test
    void test_getProductById() {
        given()
                .contentType("application/json")
                .body("{\"id\": \"5\", \"title\": \"John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet\", \"price\": \"695.0F\",\"description\": \"Silver drakens återkomst. Ett måste om man vill ha den!\",\"image\": \"https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg\"}")
                .when()
                .get("http://localhost:" + port + "/products" + "/5")
                .then()
                .statusCode(200)
                .body("id", Matchers.notNullValue())
                .body("title", Matchers.equalTo("John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet"))
                .body("price", Matchers.equalTo(695.0F))
                .body("description", Matchers.equalTo("Silver drakens återkomst. Ett måste om man vill ha den!"))
                .body("image", Matchers.equalTo("https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg"));

    }

    @Test
    void test_getProductByCategory() {
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:" + port + "/products" + "/categories" + "/electronics")
                .then()
                .statusCode(200);

    }
}
