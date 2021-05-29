package org.goodfood2.Resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
	
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.goodfood2.Entity.Adresse_Utilisateur;
import org.goodfood2.Entity.Commande;
import org.goodfood2.Entity.Utilisateur;
import org.goodfood2.utils.QueryUtils;
import org.goodfood2.utils.TokenUtils;
import org.wildfly.security.password.util.ModularCrypt;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
@Path("/User")
@Tag(name = "Utilisateur Resource", description = "L'ensemble des routes pour la partie Utilisateur")
public class UtilisateurResource {

    @Inject
    EntityManager entityManager;
    
    @Path("/")
    @GET
    public List<Utilisateur> utilisateurs(
        @DefaultValue("25") @QueryParam("pageSize") Integer pageSize, 
        @DefaultValue("1") @QueryParam("pageNumber") Integer pageNumber,
        @DefaultValue("") @QueryParam("adresseUtilisateur") String adresseUtilisateur,
        @DefaultValue("") @QueryParam("emailUtilisateur") String emailUtilisateur,
        @DefaultValue("") @QueryParam("nomUtilisateur") String nomUtilisateur,
        @DefaultValue("") @QueryParam("prenomUtilisateur") String prenomUtilisateur,
        @DefaultValue("") @QueryParam("numeroTelUtilisateur") String numeroTelUtilisateur
        ) {

        PanacheQuery<Utilisateur> utilisateurs = null;
        utilisateurs = Utilisateur.find(
            "select adresseUtilisateur, emailUtilisateur, role, idUtilisateur, nomUtilisateur, numeroTelUtilisateur, prenomUtilisateur from Utilisateur where adresseUtilisateur like '%" + 
            adresseUtilisateur + "%' and emailUtilisateur like '%" + 
            emailUtilisateur + "%' and nomUtilisateur like '%" + 
            nomUtilisateur + "%' and prenomUtilisateur like '%" +
            prenomUtilisateur + "%' and numeroTelUtilisateur like '%" + 
            numeroTelUtilisateur + "%'");
        utilisateurs.page(Page.ofSize(pageSize));
        for (int i = 0; i < pageNumber - 1; i++){
            utilisateurs.nextPage();
        }
        return utilisateurs.list();
    }

    @Path("/id/{id}")
    @GET
    public Utilisateur utilisateurId(@PathParam("id") Long id) throws Exception{
        Utilisateur utilisateur = (Utilisateur)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryString("Utilisateur", "idUtilisateur", id.toString()))
                .getResultList().get(0);
        if (utilisateur == null) {
            throw new Exception("L'utilisateur " + id + " n'existe pas.");
        }    
        return utilisateur;
    }

    @Path("/adresse/{id}")
    @GET
    public List<Adresse_Utilisateur> utilisateurIdAdresse(@PathParam("id") Long id) throws Exception{
        PanacheQuery<Adresse_Utilisateur> adressesU = Adresse_Utilisateur.find("select a.idAdresse, a.numeroAdresse, a.suppNomAdresse, a.villeAdresse, a.codePostal, a.pays from Adresse_Utilisateur a where a.utilisateur = " + id);
        return adressesU.list();
    }

    private Utilisateur utilisateurEmail(@PathParam("email") String email) throws Exception{
        Utilisateur utilisateur = (Utilisateur)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryString("Utilisateur", "emailUtilisateur", email))
                .getResultList().get(0);
        if (utilisateur == null) {
            throw new Exception("L'utilisateur qui a pour email " + email + " n'existe pas.");
        }    
        return utilisateur;
    }
    

    @Produces(MediaType.TEXT_PLAIN)
    @Path("/login/{email}&{password}")
    @POST
    public String val (@PathParam ("email") String email,  @PathParam ("password") String password) throws Exception {
        String ret = "";
        long tokenDuration = 3600;
        boolean test = false;
        Utilisateur userFound = this.utilisateurEmail(email);
        if (userFound != null) {
            test = TokenUtils.verifyPassword(password, userFound.getMdpUtilisateur());
            if (test)
                ret = TokenUtils.generateTokenSmallRye(tokenDuration, email, userFound.getIdUtilisateur(), userFound.getRole());
        }
        else 
            throw new Exception("L'utilisateur qui a pour email " + email + " n'existe pas.");   

        return ret;
    }

    @Path("/create")
    @POST
    @Transactional
    public Response creerUtilisateur(Utilisateur u) throws Exception {
        u.setMdpUtilisateur(BcryptUtil.bcryptHash(u.getMdpUtilisateur()));
        entityManager.persist(u);
        return Response.status(200).build();
    }

    @Path("/modify")
    @PATCH
    @Transactional
    public Utilisateur modifUtilisateur(Utilisateur u) throws Exception {
        return entityManager.merge(u);
    }

    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public Response supprLigneCommande(@PathParam("id") Long id) throws Exception{
        Utilisateur u = (Utilisateur)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Utilisateur", "id", id.toString()))
                .getResultList().get(0);
        if (u == null) {
            return Response.status(404).build();
        }
        entityManager.remove(u);
        return Response.status(200).build();
    }
}    