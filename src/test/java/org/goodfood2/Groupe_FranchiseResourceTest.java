package org.goodfood2;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import org.goodfood2.Entity.Groupe_Franchise;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import static io.restassured.RestAssured.*;

@QuarkusTest
@DisplayName("Tests groupes de franchise")
@TestMethodOrder(OrderAnnotation.class)
public class Groupe_FranchiseResourceTest {
    
    public String token="";
    
    @Test
    @DisplayName("Liste des groupes de franchise")
    @Order(1)
    public void testGroupesFranchise() {
        given().when().get("/Groupe_Franchise")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Creation d une groupe_franchise")
    @Order(2)
    public void testCreerGroupeFranchise() {
        Groupe_Franchise f = new Groupe_Franchise();
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .body(f)
        .when()
            .post("/Groupe_Franchise/creer/" )
        .then()
            .statusCode(200);
    } 
    @Test
    @DisplayName("Modification d une groupe_franchise")
    @Order(3)
    public void testModifGroupeFranchise() {
        Groupe_Franchise f = new Groupe_Franchise();
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .body(f)
        .when()
            .patch("/Groupe_Franchise/modifier")
        .then()
            .statusCode(200);
        
    }

    @Test
    @DisplayName("Suppression d une groupe_franchise")
    @TestSecurity(user = "testUser", roles = {"user","admin"})
    @Order(4)
    public void testSupprGroupeFranchise() {
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .when()
            .get("/Groupe_Franchise/supprimer/{id}","1")
        .then()
            .statusCode(405);
        given()
            .urlEncodingEnabled(false)
        .log()
            .all()
        .when()
            .delete("/Groupe_Franchise/supprimer/{id}","1")
        .then()
            .statusCode(200);
    }
}
