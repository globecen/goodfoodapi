package org.goodfood2;

import javax.ws.rs.core.MediaType;


import javax.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;
import org.goodfood2.Entity.Adresse_Utilisateur;
import org.goodfood2.Entity.Utilisateur;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import static io.restassured.RestAssured.*;

public class Adresse_UtilisateurResourceTest {
    
    public String token="";
    
    @Test
    @DisplayName("Liste des adresses utilisateur")
    @Order(1)
    public void testAdressesUtilisateur() {
        given().when().get("/Adresse_Utilisateur")
            .then()
            .statusCode(200);
    }

    @Test
    @DisplayName("Creation d une adresse utilisateur")
    @Order(2)
    public void testCreerAdresseUtilisateur() {
        Utilisateur u = new Utilisateur();
        Adresse_Utilisateur aF = new Adresse_Utilisateur();
        aF.setIdUtilisateur(u.getIdUtilisateur());;
        aF.setCodePostal(00000);
        aF.setNomAdresse("00000");
        aF.setNumeroAdresse(00000);
        aF.setPays("00000");
        aF.setSuppNomAdresse("00000");
        aF.setVilleAdresse("00000");
        aF.setEstActive(1);

        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .body(aF)
        .when()
            .post("/Adresse_Utilisateur/creer/" )
        .then()
            .statusCode(200);
    } 
    @Test
    @DisplayName("Modification d une adresse utilisateur")
    @Order(3)
    public void testModifAdresseUtilisateur() {
        Utilisateur u = new Utilisateur();
        Adresse_Utilisateur aF = new Adresse_Utilisateur();
        aF.setIdUtilisateur(u.getIdUtilisateur());;
        aF.setCodePostal(00001);
        aF.setNomAdresse("00000");
        aF.setNumeroAdresse(00000);
        aF.setPays("00000");
        aF.setSuppNomAdresse("00000");
        aF.setVilleAdresse("00000");
        aF.setEstActive(1);

        given()
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
            .body(aF)
        .when()
            .patch("/Adresse_Utilisateur/modifier")
        .then()
            .statusCode(200);
        
    }

    @Test
    @DisplayName("Suppression d une adresse utilisateur")
    @Order(4)
    public void testSupprAdresseUtilisateur() {
        given()
            .urlEncodingEnabled(false)
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .log()
            .all()
        .when()
            .get("/Adresse_Utilisateur/supprimer/{id}","1")
        .then()
            .statusCode(405);
        given()
            .urlEncodingEnabled(false)
        .log()
            .all()
        .when()
            .delete("/Adresse_Utilisateur/supprimer/{id}","1")
        .then()
            .statusCode(200);
    }
}
