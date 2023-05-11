package com.example.produktapi.controller;


import static io.restassured.RestAssured.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)

public class ProductServiceTest {

    @LocalServerPort
    private Integer port;



}
