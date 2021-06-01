package org.goodfood2;
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

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class UserResourceTest {
    
    @BeforeEach
    public void setURL() {
        RestAssured.baseURI = "http://[::1]:8080";
    }

    @Test
    public void testgetAllUsersEndpoint() {
        given().when().get("/User")
            .then()
            .statusCode(200);
            // .body(is());
    }

    @Test
    public void login() {
        //given().when().post("/login/quentin.alegos@gmail.com&hHxL3zXapXz3JWW")
        given()
            .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
        .when()
            .post("/User/login/{email}&{password}", "a",  "hHxL3zXapXz3JWW")
        .then()
            .statusCode(200);
    }    
    
    @Test
    public void Adresse_UtilisateurIdUser() {
        //given().when().post("/login/quentin.alegos@gmail.com&hHxL3zXapXz3JWW")

        given()
            .pathParam("id", "3")
        .when()
            .get("/User/{id}")
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
