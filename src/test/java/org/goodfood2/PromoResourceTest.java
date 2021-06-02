package org.goodfood2;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import org.goodfood2.Entity.Promo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import static io.restassured.RestAssured.*;

@QuarkusTest
@DisplayName("Tests promotions")
@TestMethodOrder(OrderAnnotation.class)
public class PromoResourceTest {
    
    public String token="";
    
    @Test
    @DisplayName("Liste des promotions")
    @Order(1)
    public void testPromotions() {
        given().when().get("/Promo")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Creation d une promo")
    @Order(2)
    public void testCreerPromo() {
        Promo f = new Promo();
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .body(f)
        .when()
            .post("/Promo/creer/" )
        .then()
            .statusCode(200);
    } 
    @Test
    @DisplayName("Modification d une promo")
    @Order(3)
    public void testModifPromo() {
        Promo f = new Promo();
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .body(f)
        .when()
            .patch("/Promo/modifier")
        .then()
            .statusCode(200);
        
    }

    @Test
    @DisplayName("Promotion par id")
    @Order(4)
    public void testPromoId() {
        given().when().get("/Promo/1")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Suppression d une promo")
    @TestSecurity(user = "testUser", roles = {"user","admin"})
    @Order(5)
    public void testSupprPromo() {
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .when()
            .get("/Promo/supprimer/{id}","1")
        .then()
            .statusCode(405);
        given()
            .urlEncodingEnabled(false)
        .log()
            .all()
        .when()
            .delete("/Promo/supprimer/{id}","1")
        .then()
            .statusCode(200);
    }
}
