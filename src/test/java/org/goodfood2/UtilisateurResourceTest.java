package org.goodfood2;
import org.goodfood2.Entity.Utilisateur;
import javax.ws.rs.core.MediaType;


import javax.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import io.restassured.response.Response;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import static io.restassured.RestAssured.*;

@QuarkusTest
@DisplayName("Tests utilisateur")
@TestMethodOrder(OrderAnnotation.class)
public class UtilisateurResourceTest {
    public String token="";
    @Test
    @DisplayName("Liste des utilisateurs")
    @Order(0)
    public void testUtilisateurs() {
        given().when().get("/Utilisateur")
        
            .then()
            .statusCode(200);
            // .body(is());
    }
    @Test
    @DisplayName("Creation d un utilisateur")
    @Order(1)
    public void testCreerUtilisateur() {
        Utilisateur u = new Utilisateur();
        u.setEmailUtilisateur("quentin.alegos@gmail.com");
        u.setMdpUtilisateur("hHxL3zXapXz3JWW");
        u.setNomUtilisateur("LE BRUN");
        u.setPrenomUtilisateur("quentin");
        u.setNumeroTelUtilisateur("10000");
        u.setRole("admin");

        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .body(u)
        .when()
            .post("/Utilisateur/creer/" )
        .then()
            .statusCode(200);
    } 
    @Test
    @DisplayName("Modification d un utilisateur")
    @Order(2)
    public void testModifUtilisateur() {
        Utilisateur u = new Utilisateur();
        u.setEmailUtilisateur("quentin.alegos@gmail.com");
        u.setMdpUtilisateur("hHxL3zXapXz3JWW");
        u.setNomUtilisateur("LE BRUN");
        u.setPrenomUtilisateur("quentine");
        u.setNumeroTelUtilisateur("10000");
        u.setRole("admin");
        u.setIdUtilisateur(1);

        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .body(u)
        .when()
            .patch("/Utilisateur/modifier")
        .then()
            .statusCode(200);
        
    }
    @Test   
    @DisplayName("Connexion")
    @Order(3)
    public void testConnexionUtilisateur() {
        Response r = 
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
        .log()
            .all()
        .when()
            .get("/Utilisateur/connexion/{email}&{password}", "quentin.alegos@gmail.com", "hHxL3zXapXz3JWW" )
        .then().extract().response();
        r.then()
            .statusCode(200);
        token = r.asString();
    }
    @Test
    @DisplayName("Suppression d un utilisateur")
    @TestSecurity(user = "testUser", roles = {"user"})
    @Order(4)
    public void testSupprUtilisateur() {
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .when()
            .get("/Utilisateur/supprimer/{id}","1")
        .then()
            .statusCode(405);
        given()
            .urlEncodingEnabled(false)
        .log()
            .all()
        .when()
            .delete("/Utilisateur/supprimer/{id}","1")
        .then()
            .statusCode(200);
    }
}
