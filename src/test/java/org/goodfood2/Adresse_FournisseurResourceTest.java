package org.goodfood2;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import org.goodfood2.Entity.Adresse_Fournisseur;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import static io.restassured.RestAssured.*;

@QuarkusTest
@DisplayName("Tests adresses fournisseur")
@TestMethodOrder(OrderAnnotation.class)
public class Adresse_FournisseurResourceTest {
    
    public String token="";
    
    @Test
    @DisplayName("Liste des adresses fournisseur")
    @Order(1)
    public void testAdressesFournisseur() {
        given().when().get("/Adresse_Fournisseur")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Creation d une adresse fournisseur")
    @Order(2)
    public void testCreerAdresseFournisseur() {
        Adresse_Fournisseur aF = new Adresse_Fournisseur();

        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .body(aF)
        .when()
            .post("/Adresse_Fournisseur/creer/" )
        .then()
            .statusCode(200);
    } 
    @Test
    @DisplayName("Modification d une adresse fournisseur")
    @Order(3)
    public void testModifAdresseFournisseur() {
        Adresse_Fournisseur aF = new Adresse_Fournisseur();

        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .body(aF)
        .when()
            .patch("/Adresse_Fournisseur/modifier")
        .then()
            .statusCode(200);
        
    }

    @Test
    @DisplayName("Suppression d une adresse fournisseur")
    @TestSecurity(user = "testUser", roles = {"user","admin"})
    @Order(4)
    public void testSupprAdresseFournisseur() {
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .when()
            .get("/Adresse_Fournisseur/supprimer/{id}","1")
        .then()
            .statusCode(405);
        given()
            .urlEncodingEnabled(false)
        .log()
            .all()
        .when()
            .delete("/Adresse_Fournisseur/supprimer/{id}","1")
        .then()
            .statusCode(200);
    }
}
