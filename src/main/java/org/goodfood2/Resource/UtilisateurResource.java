package org.goodfood2.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
	
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.goodfood2.Entity.Utilisateur;
import org.goodfood2.utils.QueryUtils;
import org.goodfood2.utils.TokenUtils;
@Path("/User")
@Tag(name = "Utilisateur Resource", description = "L'ensemble des routes pour la partie Utilisateur")
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
    public List<Utilisateur> utilisateurs() {
        return entityManager.createQuery("select adresseUtilisateur, emailUtilisateur, idRole, idUtilisateur, mdpUtilisateur, nomUtilisateur, numeroTelUtilisateur, prenomUtilisateur from Utilisateur").getResultList();
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
    @Path("/{email}&{password}")
    @GET
    public Utilisateur utilisateurEmailMdp(@PathParam("email") String email, @PathParam("password") String mdp) throws Exception{
        Utilisateur utilisateur = (Utilisateur)entityManager.createQuery(
            "from Utilisateur obj where emailUtilisateur = '" + email + "' and mdpUtilisateur = '" + mdp + "'")
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
        String ret;
        long tokenDuration = 3600;
        Utilisateur utilisateur = this.utilisateurEmail(email);
        String token = TokenUtils.generateToken(tokenDuration, email, utilisateur.getIdUtilisateur(), utilisateur.getIdRole());
        utilisateur = this.utilisateurEmailMdp(email, password);
        if (utilisateur != null) ret = token;
        else ret = "Email ou mot de passe incorrect";
        return ret;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @POST
    @Transactional
    public Response creerUtilisateur(Utilisateur u) throws Exception {
        entityManager.persist(u);
        return Response.status(200).build();
    }
}    