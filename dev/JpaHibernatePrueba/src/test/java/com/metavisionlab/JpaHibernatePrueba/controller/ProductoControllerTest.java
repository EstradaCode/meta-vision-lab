package com.metavisionlab.JpaHibernatePrueba.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort; // ✅ Correcto


import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductoControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void crearProducto_deberiaRetornar201YDTO() {
        String json = """
            {
                "nombre": "Botella",
                "marca": "Nalgene",
                "costo": 2500.0,
                "cantidadDisponible": 8.0
            }
        """;

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("/productos/crear")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("nombre", equalTo("Botella"))
                .body("marca", equalTo("Nalgene"));
    }
}
