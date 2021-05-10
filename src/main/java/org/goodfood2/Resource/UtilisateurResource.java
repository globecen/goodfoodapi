package org.goodfood2.Resource;




import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
	
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.netty.util.internal.ResourcesUtil;
import org.eclipse.microprofile.metrics.annotation.Counted;


import io.quarkus.panache.common.Parameters;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;

import org.goodfood2.Entity.Utilisateur;
import org.goodfood2.utils.QueryUtils;
import org.goodfood2.utils.TokenUtils;

@Path("/User")
public class UtilisateurResource {

    @Inject
    EntityManager entityManager;

    /*@Counted(
        name = "LeNombreDeRequete",
        description = "Donne le nombre de requete a la base"
    )*/

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Utilisateur> utilisateur() {
        return entityManager.createQuery(
            QueryUtils.makeFindAllQuery("Utilisateur"))
                .getResultList();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/id{id}")
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

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/nom{nom}")
    @GET
    public Utilisateur utilisateurNom(@PathParam("nom") String nom) throws Exception{
        Utilisateur utilisateur = (Utilisateur)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryString("Utilisateur", "nomUtilisateur", nom))
                .getResultList().get(0);
        if (utilisateur == null) {
            throw new Exception("L'utilisateur " + nom + " n'existe pas.");
        }    
        return utilisateur;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/email{email}")
    @GET
    public Utilisateur utilisateurEmail(@PathParam("email") String email) throws Exception{
        Utilisateur utilisateur = (Utilisateur)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryString("Utilisateur", "emailUtilisateur", email))
                .getResultList().get(0);
        if (utilisateur == null) {
            throw new Exception("L'utilisateur qui a pour email " + email + " n'existe pas.");
        }    
        return utilisateur;
    }
    
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{email}&{password}")
    @GET
    public Utilisateur utilisateurEmailMdp(@PathParam("email") String email, @PathParam("mdp") String mdp) throws Exception{
        Utilisateur utilisateur = (Utilisateur)entityManager.createQuery(
            QueryUtils.makeFindBy2ParamQueryString("Utilisateur", "emailUtilisateur", email, "mdpUtilisateur", mdp))
                .getResultList().get(0);
        if (utilisateur == null) {
            throw new Exception("L'utilisateur qui a pour email " + email + " n'existe pas.");
        }    
        return utilisateur;
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Path("/login/{email}&{password}")
    @POST
    public String val (@PathParam ("email")String email,  @PathParam ("password")String password) throws Exception {
        String ret;
        long tokenDuration = 3600;
        Utilisateur utilisateur = this.utilisateurEmail(email);
        String token = TokenUtils.generateToken(tokenDuration, email, utilisateur.getIdUtilisateur(), utilisateur.getIdRole());
        utilisateur = this.utilisateurEmailMdp(email, password);
        if (utilisateur != null) ret = token;
        else ret = "Email ou mot de passe incorrect";
        return ret;
    }
}    