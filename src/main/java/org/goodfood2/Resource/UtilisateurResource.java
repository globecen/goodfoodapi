package org.goodfood2.Resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
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

import com.arjuna.ats.internal.arjuna.recovery.PeriodicRecovery.Status;

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
     * @param pageSize               Le nombre d utilisateurs par page.
     * @param pageNumber             Le numero de page.
     * @param d_emailUtilisateur     Le mail de l utilisateur.
     * @param f_nomUtilisateur       Le nom de l utilisateur.
     * @param h_prenomUtilisateur    Le prenom de l utilisateur.
     * @param g_numeroTelUtilisateur Le numero de telephone de l utilisateur.
     * @return La liste d utilisateurs.
     */
    @Path("/")
    @GET
    public List<Utilisateur> utilisateurs(@DefaultValue("25") @QueryParam("pageSize") Integer pageSize,
            @DefaultValue("1") @QueryParam("pageNumber") Integer pageNumber,
            @DefaultValue("") @QueryParam("d_emailUtilisateur") String d_emailUtilisateur,
            @DefaultValue("") @QueryParam("f_nomUtilisateur") String f_nomUtilisateur,
            @DefaultValue("") @QueryParam("h_prenomUtilisateur") String h_prenomUtilisateur,
            @DefaultValue("") @QueryParam("g_numeroTelUtilisateur") String g_numeroTelUtilisateur) {

        PanacheQuery<Utilisateur> utilisateurs = null;
        utilisateurs = Utilisateur.find("from Utilisateur where d_emailUtilisateur like '%" + d_emailUtilisateur
                + "%' and f_nomUtilisateur like '%" + f_nomUtilisateur + "%' and h_prenomUtilisateur like '%"
                + h_prenomUtilisateur + "%' and g_numeroTelUtilisateur like '%" + g_numeroTelUtilisateur + "%'");
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
                .createQuery(QueryUtils.makeFindByParamQueryString("Utilisateur", "a_idUtilisateur", id.toString()))
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
    public List<Adresse_Utilisateur> utilisateurIdAdresse(@PathParam("id") Long id) throws Exception {
        PanacheQuery<Adresse_Utilisateur> adressesU = Adresse_Utilisateur
                .find("from Adresse_Utilisateur a where a.b_idUtilisateur = " + id);
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
        var userList = entityManager
                .createQuery(QueryUtils.makeFindByParamQueryString("Utilisateur", "d_emailUtilisateur", email))
                .getResultList();
        if (userList.size() > 0) {
            Utilisateur utilisateur = (Utilisateur) entityManager
                    .createQuery(QueryUtils.makeFindByParamQueryString("Utilisateur", "d_emailUtilisateur", email))
                    .getResultList().get(0);
            return utilisateur;

        } else {
            return null;
        }
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
            test = SecurityUtils.verifyPassword(password, userFound.retrieveCryptedPwd());
            if (test)
                ret = SecurityUtils.generateTokenSmallRye(tokenDuration, email, userFound.getA_idUtilisateur(),
                        userFound.getI_role());
            else {
                throw new Exception("Identifiants incorrects.");
            }
        } else
            throw new Exception("Identifiants incorrects.");

        return ret;
    }

    /**
     * Tentative de connexion a partir d un mail et d'un token.
     * 
     * @param email    Le mail de l utilisateur.
     * @param password Le mot de passe de l utilisateur.
     * @return val Le token de connexion.
     * @throws Exception
     */
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/refresh/{email")
    @RolesAllowed({ "user" })
    @POST
    public String refreshToken(@PathParam("email") String email) throws Exception {
        String ret = "";
        long tokenDuration = 3600;
        Utilisateur userFound = this.utilisateurEmail(email);
        if (userFound != null) {
            ret = SecurityUtils.generateTokenSmallRye(tokenDuration, email, userFound.getA_idUtilisateur(),
                    userFound.getI_role());
        } else
            throw new Exception("Identifiants ou token incorrects.");

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
        u.setE_mdpUtilisateur(BcryptUtil.bcryptHash(u.getE_mdpUtilisateur()));
        entityManager.persist(u);
        return Response.status(200).build();
    }

    /**
     * Modifie un utilisateur.
     * 
     * @param p L utilisateur.
     * @return L utilisateur modifie.
     */
    @Path("/modifier")
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
    @Path("/supprimer/{id}")
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