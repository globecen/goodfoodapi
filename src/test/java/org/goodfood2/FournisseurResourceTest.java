package org.goodfood2;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import org.goodfood2.Entity.Fournisseur;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import static io.restassured.RestAssured.*;

@QuarkusTest
@DisplayName("Tests fournisseurs")
@TestMethodOrder(OrderAnnotation.class)
public class FournisseurResourceTest {
    
    public String token="";
    
    @Test
    @DisplayName("Liste des fournisseurs")
    @Order(1)
    public void testFournisseur() {
        given().when().get("/Fournisseur")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Creation d une fournisseur")
    @Order(2)
    public void testCreerFournisseur() {
        Fournisseur f = new Fournisseur();
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .body(f)
        .when()
            .post("/Fournisseur/creer/" )
        .then()
            .statusCode(200);
    } 
    @Test
    @DisplayName("Modification d une fournisseur")
    @Order(3)
    public void testModifFournisseur() {
        Fournisseur f = new Fournisseur();
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .body(f)
        .when()
            .patch("/Fournisseur/modifier")
        .then()
            .statusCode(200);
        
    }

    @Test
    @DisplayName("Suppression d une fournisseur")
    @TestSecurity(user = "testUser", roles = {"user","admin"})
    @Order(4)
    public void testSupprFournisseur() {
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .when()
            .get("/Fournisseur/supprimer/{id}","1")
        .then()
            .statusCode(405);
        given()
            .urlEncodingEnabled(false)
        .log()
            .all()
        .when()
            .delete("/Fournisseur/supprimer/{id}","1")
        .then()
            .statusCode(200);
    }
}
