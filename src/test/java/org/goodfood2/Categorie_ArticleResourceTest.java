package org.goodfood2;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import org.goodfood2.Entity.Categorie_Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import static io.restassured.RestAssured.*;

@QuarkusTest
@DisplayName("Tests categories article")
@TestMethodOrder(OrderAnnotation.class)
public class Categorie_ArticleResourceTest {
    
    public String token="";
    
    @Test
    @DisplayName("Liste des categories article")
    @Order(1)
    public void testCategoriesArticle() {
        given().when().get("/Categorie_Article")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Creation d une categorie article")
    @Order(2)
    public void testCreerCategorieArticle() {
        Categorie_Article cA = new Categorie_Article();

        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .body(cA)
        .when()
            .post("/Categorie_Article/creer/" )
        .then()
            .statusCode(200);
    } 
    @Test
    @DisplayName("Modification d une categorie article")
    @Order(3)
    public void testModifCategorieArticle() {
        Categorie_Article cA = new Categorie_Article();


        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .body(cA)
        .when()
            .patch("/Categorie_Article/modifier")
        .then()
            .statusCode(200);
        
    }

    @Test
    @DisplayName("Suppression d une categorie article")
    @TestSecurity(user = "testUser", roles = {"user","admin"})
    @Order(4)
    public void testSupprCategorieArticle() {
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .when()
            .get("/Categorie_Article/supprimer/{id}","1")
        .then()
            .statusCode(405);
        given()
            .urlEncodingEnabled(false)
        .log()
            .all()
        .when()
            .delete("/Categorie_Article/supprimer/{id}","1")
        .then()
            .statusCode(200);
    }
}
