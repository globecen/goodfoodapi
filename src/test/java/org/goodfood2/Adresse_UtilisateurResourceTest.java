package org.goodfood2;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import org.goodfood2.Entity.Adresse_Utilisateur;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import static io.restassured.RestAssured.*;

@QuarkusTest
@DisplayName("Tests adresses utilisateur")
@TestMethodOrder(OrderAnnotation.class)
public class Adresse_UtilisateurResourceTest {
    
    public String token="";
    
    @Test
    @DisplayName("Liste des adresses utilisateur")
    @Order(1)
    public void testAdressesUtilisateur() {
        given().when().get("/Adresse_Utilisateur")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Creation d une adresse utilisateur")
    @Order(2)
    public void testCreerAdresseUtilisateur() {
        Adresse_Utilisateur aF = new Adresse_Utilisateur();

        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .body(aF)
        .when()
            .post("/Adresse_Utilisateur/creer/" )
        .then()
            .statusCode(200);
    } 
    @Test
    @DisplayName("Modification d une adresse utilisateur")
    @Order(3)
    public void testModifAdresseUtilisateur() {
        Adresse_Utilisateur aF = new Adresse_Utilisateur();

        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .body(aF)
        .when()
            .patch("/Adresse_Utilisateur/modifier")
        .then()
            .statusCode(200);
        
    }

    @Test
    @DisplayName("Suppression d une adresse utilisateur")
    @TestSecurity(user = "testUser", roles = {"user","admin"})
    @Order(4)
    public void testSupprAdresseUtilisateur() {
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .when()
            .get("/Adresse_Utilisateur/supprimer/{id}","1")
        .then()
            .statusCode(405);
        given()
            .urlEncodingEnabled(false)
        .log()
            .all()
        .when()
            .delete("/Adresse_Utilisateur/supprimer/{id}","1")
        .then()
            .statusCode(200);
    }
}
