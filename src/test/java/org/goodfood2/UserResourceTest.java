package org.goodfood2;
import org.goodfood2.Entity.Utilisateur;
import org.goodfood2.Resource.UtilisateurResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.HttpHeaders;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@DisplayName("Tests utilisateur")
@TestMethodOrder(OrderAnnotation.class)
public class UserResourceTest {
    
    @Test
    @DisplayName("Liste des utilisateurs")
    @Order(0)
    public void testgetAllUsersEndpoint() {
        given().when().get("/Utilisateur")
        
            .then()
            .statusCode(200);
            // .body(is());
    }
    @Test
    @DisplayName("Creation d un utilisateur")
    @Order(1)
    public void testRegisterEndpoint() {
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
            .post("/Utilisateur/create/" )
        .then()
            .statusCode(200);
    }    

    @Test
    @DisplayName("Connexion")
    @Order(2)
    public void testLoginEndpoint() {
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
        .log()
            .all()
        .when()
            .get("/Utilisateur/login/{email}&{password}", "quentin.alegos@gmail.com", "hHxL3zXapXz3JWW" )
        .then()
            .statusCode(200);

        
    }

    // @Test
    // public void testgetUserIdEndpoint(double id) {
    //     given()
    //       .when().get("/id="+id)
    //       .then()
    //          .statusCode(200)
    //          .body(is(Users.findById(id)));
    // }
    // @Test
    // public void testgetUserEmailEndpoint(String email) {
    //     given()
    //       .when().get("/email="+email)
    //       .then()
    //          .statusCode(200)
    //          .body(is(Users.find(email)));
    // }
    // @Test
    // public void testgetUserNameEndpoint(String name) {
    //     given()
    //       .when().get("/name="+name)
    //       .then()
    //          .statusCode(200)
    //          .body(is(Users.find(name)));
    // }
}
