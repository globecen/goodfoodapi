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
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.goodfood2.Entity.Adresse_Utilisateur;
import org.goodfood2.Entity.Utilisateur;
import org.goodfood2.utils.QueryUtils;
import org.goodfood2.utils.SecurityUtils;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;

/**
 * Route liees aux utilisateurs.
 */
@Path("/Utilisateur")
@Tag(name = "Utilisateur Resource", description = "L'ensemble des routes pour la partie Utilisateur")
public class UtilisateurResource {

    // Permet de gerer les entitees.
    @Inject
    EntityManager entityManager;

    /**
     * Recupere la liste des utilisateurs en fonctions de plusieurs parametres.
     * 
     * @param pageSize             Le nombre d utilisateurs par page.
     * @param pageNumber           Le numero de page.
     * @param adresseUtilisateur   L adresse de l utilisateur.
     * @param emailUtilisateur     Le mail de l utilisateur.
     * @param nomUtilisateur       Le nom de l utilisateur.
     * @param prenomUtilisateur    Le prenom de l utilisateur.
     * @param numeroTelUtilisateur Le numero de telephone de l utilisateur.
     * @return La liste d utilisateurs.
     */
    @Path("/")
    @GET
    public List<Utilisateur> utilisateurs(@DefaultValue("25") @QueryParam("pageSize") Integer pageSize,
            @DefaultValue("1") @QueryParam("pageNumber") Integer pageNumber,
            @DefaultValue("") @QueryParam("adresseUtilisateur") String adresseUtilisateur,
            @DefaultValue("") @QueryParam("emailUtilisateur") String emailUtilisateur,
            @DefaultValue("") @QueryParam("nomUtilisateur") String nomUtilisateur,
            @DefaultValue("") @QueryParam("prenomUtilisateur") String prenomUtilisateur,
            @DefaultValue("") @QueryParam("numeroTelUtilisateur") String numeroTelUtilisateur) {

        PanacheQuery<Utilisateur> utilisateurs = null;
        utilisateurs = Utilisateur.find(
            "select emailUtilisateur, role, idUtilisateur, nomUtilisateur, numeroTelUtilisateur, prenomUtilisateur from Utilisateur where d_emailUtilisateur like '%" + emailUtilisateur 
            + "%' and f_nomUtilisateur like '%" + nomUtilisateur 
            + "%' and h_prenomUtilisateur like '%" + prenomUtilisateur 
            + "%' and g_numeroTelUtilisateur like '%" + numeroTelUtilisateur + "%'");
        utilisateurs.page(Page.ofSize(pageSize));
        for (int i = 0; i < pageNumber - 1; i++) {
            utilisateurs.nextPage();
        }

        return utilisateurs.list();
    }

    /**
     * Recupere un utilisateur.
     * 
     * @param id L id de l utilisateur.
     * @return L utilisateur.
     */
    @Path("/{id}")
    @GET
    public Utilisateur utilisateurId(@PathParam("id") Long id) throws Exception {
        Utilisateur utilisateur = (Utilisateur) entityManager
                .createQuery(QueryUtils.makeFindByParamQueryString("Utilisateur", "idUtilisateur", id.toString()))
                .getResultList().get(0);
        if (utilisateur == null) {
            throw new Exception("L'utilisateur " + id + " n'existe pas.");
        }
        return utilisateur;
    }

    /**
     * Recupere les adresses liees a un utilisateur.
     * 
     * @param id L id de l utilisateur.
     * @return La liste des adresses.
     * @throws Exception
     */
    @Path("/{id}/Adresse_Utilisateur")
    @GET
    public List<Adresse_Utilisateur> utilisateurIdAdresse(@PathParam("id") Long id) throws Exception{
        PanacheQuery<Adresse_Utilisateur> adressesU = Adresse_Utilisateur.find("select a.a_idAdresse, a.e_numeroAdresse, a.g_suppNomAdresse, a.h_villeAdresse, a.c_codePostal, a.f_pays from Adresse_Utilisateur a where a.b_idUtilisateur = " + id);
        return adressesU.list();
    }

    /**
     * Recupere l utilisateur a partir d un mail.
     * 
     * @param email Le mail de l utilisateur.
     * @return L utilisateur.
     * @throws Exception
     */
    private Utilisateur utilisateurEmail(@PathParam("email") String email) throws Exception {
        Utilisateur utilisateur = (Utilisateur) entityManager
                .createQuery(QueryUtils.makeFindByParamQueryString("Utilisateur", "emailUtilisateur", email))
                .getResultList().get(0);
        return utilisateur;
    }

    /**
     * Tentative de connexion a partir d un mail et d un mot de passe.
     * 
     * @param email    Le mail de l utilisateur.
     * @param password Le mot de passe de l utilisateur.
     * @return val Le token de connexion.
     * @throws Exception
     */
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/connexion/{email}&{password}")
    @POST
    public String connexionUtilisateur(@PathParam("email") String email, @PathParam("password") String password)
            throws Exception {
        String ret = "";
        long tokenDuration = 3600;
        boolean test = false;
        Utilisateur userFound = this.utilisateurEmail(email);
        if (userFound != null) {
            test = SecurityUtils.verifyPassword(password, userFound.retrieveEncryptPassword());
            if (test)
                ret = SecurityUtils.generateTokenSmallRye(tokenDuration, email, userFound.getIdUtilisateur(),
                        userFound.getRole());
        } else
            throw new Exception("L'utilisateur qui a pour email " + email + " n'existe pas.");

        return ret;
    }

    /**
     * Cree un utilisateur.
     * 
     * @param p L utilisateur.
     * @return Le statut de la reponse.
     */
    @PermitAll
    @Path("/creer")
    @POST
    @Transactional
    public Response creerUtilisateur(Utilisateur u) throws Exception {
        u.setMdpUtilisateur(BcryptUtil.bcryptHash(u.retrieveEncryptPassword()));
        entityManager.persist(u);
        return Response.status(200).build();
    }

    /**
     * Modifie un utilisateur.
     * 
     * @param p L utilisateur.
     * @return L utilisateur modifie.
     */
    @Path("/modify")
    @PATCH
    @Transactional
    public Utilisateur modifUtilisateur(Utilisateur u) throws Exception {
        return entityManager.merge(u);
    }

    /**
     * Supprime un utilisateur.
     * 
     * @param id L id de l utilisateur.
     * @return Le statut de la reponse.
     * @throws Exception
     */
    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public Response supprUtilisateur(@PathParam("id") Long id) throws Exception {
        Utilisateur u = (Utilisateur) entityManager
                .createQuery(QueryUtils.makeFindByParamQueryInt("Utilisateur", "id", id.toString())).getResultList()
                .get(0);
        if (u == null) {
            return Response.status(404).build();
        }
        entityManager.remove(u);
        return Response.status(200).build();
    }
}