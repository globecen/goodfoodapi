package org.goodfood2;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import org.goodfood2.Entity.Franchise;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import static io.restassured.RestAssured.*;

@QuarkusTest
@DisplayName("Tests franchises")
@TestMethodOrder(OrderAnnotation.class)
public class FranchiseResourceTest {
    
    public String token="";
    
    @Test
    @DisplayName("Liste des franchises")
    @Order(1)
    public void testFranchise() {
        given().when().get("/Franchise")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Creation d une franchise")
    @Order(2)
    public void testCreerFranchise() {
        Franchise f = new Franchise();
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .body(f)
        .when()
            .post("/Franchise/creer/" )
        .then()
            .statusCode(200);
    } 
    @Test
    @DisplayName("Modification d une franchise")
    @Order(3)
    public void testModifFranchise() {
        Franchise f = new Franchise();
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .body(f)
        .when()
            .patch("/Franchise/modifier")
        .then()
            .statusCode(200);
        
    }

    @Test
    @DisplayName("Suppression d une franchise")
    @TestSecurity(user = "testUser", roles = {"user","admin"})
    @Order(4)
    public void testSupprFranchise() {
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .when()
            .get("/Franchise/supprimer/{id}","1")
        .then()
            .statusCode(405);
        given()
            .urlEncodingEnabled(false)
        .log()
            .all()
        .when()
            .delete("/Franchise/supprimer/{id}","1")
        .then()
            .statusCode(200);
    }
}
