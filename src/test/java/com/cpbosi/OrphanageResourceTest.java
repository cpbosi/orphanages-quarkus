package com.cpbosi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import com.cpbosi.dto.CreateOrphanageDTO;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class OrphanageResourceTest {

    private static final String NAME_ORPHANAGE_INSERT = "Orphanage insert";

    @Test
    public void testGetOrphanagesEndpoint() {
        given()
          .when().get("/orphanages")
          .then()
             .statusCode(200)
             .body("name",  CoreMatchers.hasItem("Teste Casa Lar"));
    }

    @Test
    public void testPostOrphanagesEndpoint() {
        CreateOrphanageDTO orphanage = new CreateOrphanageDTO();
        orphanage.setName(NAME_ORPHANAGE_INSERT);

        given()
        .contentType(ContentType.JSON)
        .body(orphanage)
        .when().post("/orphanages")
          .then()
             .statusCode(200); 
    }

}