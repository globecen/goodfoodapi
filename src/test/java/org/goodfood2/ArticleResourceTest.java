package org.goodfood2;

import org.goodfood2.Entity.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

public class ArticleResourceTest {
    public String token="";
    
    @Test
    @DisplayName("Liste des articles")
    @Order(1)
    public void testArticles() {
        given().when().get("/Article")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Creation d une article")
    @Order(2)
    public void testCreerArticle() {
        Article a = new Article();
        a.setLibelleArticle("00000");

        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .body(a)
        .when()
            .post("/Article/creer/" )
        .then()
            .statusCode(200);
    } 
    @Test
    @DisplayName("Modification d une article")
    @Order(3)
    public void testModifArticle() {
        Article a = new Article();       
        a.setLibelleArticle("00000");

        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .body(a)
        .when()
            .patch("/Article/modifier")
        .then()
            .statusCode(200);
        
    }

    @Test
    @DisplayName("Suppression d une article")
    @Order(4)
    public void testSupprArticle() {
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .when()
            .get("/Article/supprimer/{id}","1")
        .then()
            .statusCode(405);
        given()
            .urlEncodingEnabled(false)
        .log()
            .all()
        .when()
            .delete("/Article/supprimer/{id}","1")
        .then()
            .statusCode(200);
    }
}
