package org.goodfood2;

import org.goodfood2.Entity.Allergene;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;



public class AllergeneResourceTest {
    public String token="";
    
    @Test
    @DisplayName("Liste des allergenes")
    @Order(1)
    public void testAdressesFournisseur() {
        given().when().get("/Allergene")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Creation d une allergene")
    @Order(2)
    public void testCreerAllergene() {
        Allergene a = new Allergene();
        a.setLibelleAllergene("00000");

        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .body(a)
        .when()
            .post("/Allergene/creer/" )
        .then()
            .statusCode(200);
    } 
    @Test
    @DisplayName("Modification d une allergene")
    @Order(3)
    public void testModifAllergene() {
        Allergene a = new Allergene();       
        a.setLibelleAllergene("00000");

        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .body(a)
        .when()
            .patch("/Allergene/modifier")
        .then()
            .statusCode(200);
        
    }

    @Test
    @DisplayName("Suppression d une allergene")
    @Order(4)
    public void testSupprAllergene() {
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .when()
            .get("/Allergene/supprimer/{id}","1")
        .then()
            .statusCode(405);
        given()
            .urlEncodingEnabled(false)
        .log()
            .all()
        .when()
            .delete("/Allergene/supprimer/{id}","1")
        .then()
            .statusCode(200);
    }
}
