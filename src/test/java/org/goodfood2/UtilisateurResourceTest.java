package org.goodfood2;

import org.goodfood2.Entity.Utilisateur;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;

import static io.restassured.RestAssured.*;

@QuarkusTest
@DisplayName("Tests utilisateur")
@TestMethodOrder(OrderAnnotation.class)
public class UtilisateurResourceTest {

    public String token = "";

    @Test
    @DisplayName("Liste des utilisateurs")
    @Order(1)
    public void testUtilisateurs() {
        given().when().get("/Utilisateur")

                .then().statusCode(200);
    }

    @Test
    @DisplayName("Creation d un utilisateur")
    @Order(2)
    public void testCreerUtilisateur() {
        Utilisateur u = new Utilisateur();
        u.setD_emailUtilisateur("quentin.alegos@gmail.com");
        u.setE_mdpUtilisateur(BcryptUtil.bcryptHash("test"));

        given().urlEncodingEnabled(false).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).log().all()
                .body(u).when().post("/Utilisateur/creer/").then().statusCode(200);
    }

    @Test
    @DisplayName("Modification d un utilisateur")
    @Order(3)
    public void testModifUtilisateur() {
        Utilisateur u = new Utilisateur();
        u.setD_emailUtilisateur("quentin.alegos@gmail.com");
        u.setE_mdpUtilisateur(BcryptUtil.bcryptHash("test"));
        u.setF_nomUtilisateur("bobby");
        u.setI_role("admin");
        u.setA_idUtilisateur(1);

        given().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).body(u).when()
                .patch("/Utilisateur/modifier").then().statusCode(200);

    }

    @Test
    @DisplayName("Utilisateur par id")
    @Order(4)
    public void testUtilisateurId() {
        given().when().get("/Utilisateur/1").then().statusCode(200);
    }

    @Test
    @DisplayName("Addresses par idUtilisateur")
    @Order(5)
    public void testUtilisateurEmail() {
        given().when().get("/Utilisateur/1").then().statusCode(200);
    }

    @Test
    @DisplayName("Connexion")
    @Order(6)
    public void testConnexionUtilisateur() {
        given().urlEncodingEnabled(false).when().header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).log().all()
                .post("/Utilisateur/connexion/{email}&{password}", "quentin.alegos@gmail.com", "test").then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Suppression d un utilisateur")
    @TestSecurity(user = "testUser", roles = { "user", "admin" })
    @Order(7)
    public void testSupprUtilisateur() {
        given().urlEncodingEnabled(false).header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).log().all().when()
                .get("/Utilisateur/supprimer/{id}", "1").then().statusCode(405);
        given().urlEncodingEnabled(false).log().all().when().delete("/Utilisateur/supprimer/{id}", "1").then()
                .statusCode(200);
    }
}
