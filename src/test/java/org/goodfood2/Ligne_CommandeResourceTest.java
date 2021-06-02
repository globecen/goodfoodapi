package org.goodfood2;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;

import org.goodfood2.Entity.Ligne_Commande;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import static io.restassured.RestAssured.*;

@QuarkusTest
@DisplayName("Tests lignes de commande")
@TestMethodOrder(OrderAnnotation.class)
public class Ligne_CommandeResourceTest {
    
    public String token="";
    
    @Test
    @DisplayName("Liste des lignes de commande")
    @Order(1)
    public void testLignesCommande() {
        given().when().get("/Ligne_Commande")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Creation d une ligne_commande")
    @Order(2)
    public void testCreerLigneCommande() {
        Ligne_Commande[] lC = {new Ligne_Commande()};
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .body(lC)
        .when()
            .post("/Ligne_Commande/creer/" )
        .then()
            .statusCode(200);
    } 
}
