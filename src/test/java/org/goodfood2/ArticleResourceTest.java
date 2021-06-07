package org.goodfood2;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import org.goodfood2.Entity.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import static io.restassured.RestAssured.*;

@QuarkusTest
@DisplayName("Tests articles")
@TestMethodOrder(OrderAnnotation.class)
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
    @DisplayName("Creation d un article")
    @TestSecurity(user = "testUser", roles = {"user","admin"})
    @Order(2)
    public void testCreerArticle() {
        Article a = new Article();
        a.setB_idCategorieArticle(0);
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
    @DisplayName("Modification d un article")
    @TestSecurity(user = "testUser", roles = {"user","admin"})
    @Order(3)
    public void testModifArticle() {
        Article a = new Article();
        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .body(a)
        .when()
            .patch("/Article/modifier")
        .then()
            .statusCode(200);
        
    }

    @Test
    @DisplayName("Nombre d articles")
    @Order(4)
    public void testNombreArticle() {
        given().when().get("/Article/nombre")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Nombre d ingredients")
    @Order(5)
    public void testNombreIngr() {
        given().when().get("/Article/Ingr/nombre")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Nombre de menus")
    @Order(6)
    public void testNombreMenu() {
        given().when().get("/Article/Menu/nombre")
            .then()
            .statusCode(200);
    }
    
    @Test
    @DisplayName("Article par id")
    @Order(7)
    public void testArticleId() {
        given().when().get("/Article/1")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Allergenes par idArticle")
    @Order(8)
    public void testArtAllergene() {
        given().when().get("/Article/1/Allergene")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Promotions par idArticle")
    @Order(9)
    public void testArtPromo() {
        given().when().get("/Article/1/Promo")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("idCategorie par idArticle")
    @Order(10)
    public void testCategorieArticleId() {
        given().when().get("/Article/1/Categorie_Article")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Suppression d un article")
    @TestSecurity(user = "testUser", roles = {"user","admin"})
    @Order(11)
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
