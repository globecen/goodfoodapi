package org.goodfood2;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import org.goodfood2.Entity.Commande;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import static io.restassured.RestAssured.*;

@QuarkusTest
@DisplayName("Tests commandes")
@TestMethodOrder(OrderAnnotation.class)
public class CommandeResourceTest {
    
    public String token="";
    
    @Test
    @DisplayName("Liste des commandes")
    @Order(1)
    public void testCommande() {
        given().when().get("/Commande")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Creation d une commande")
    @Order(2)
    public void testCreerCommande() {
        
        Commande c = new Commande();
        c.setC_idAdresseFacturation(0);
        c.setD_idAdresseLivraison(0);
        c.setB_idUtilisateur(0);
        c.setF_totalTtc(-1);
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .body(c)
        .when()
            .post("/Commande/creer/" )
        .then()
            .statusCode(200);
    } 
    @Test
    @DisplayName("Modification d une commande")
    @Order(3)
    public void testModifCommande() {
        Commande c = new Commande();
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .body(c)
        .when()
            .patch("/Commande/modifier")
        .then()
            .statusCode(200);
        
    }

    @Test
    @DisplayName("Suppression d une commande")
    @TestSecurity(user = "testUser", roles = {"user","admin"})
    @Order(4)
    public void testSupprCommande() {
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .when()
            .get("/Commande/supprimer/{id}","1")
        .then()
            .statusCode(405);
        given()
            .urlEncodingEnabled(false)
        .log()
            .all()
        .when()
            .delete("/Commande/supprimer/{id}","1")
        .then()
            .statusCode(200);
    }
}
