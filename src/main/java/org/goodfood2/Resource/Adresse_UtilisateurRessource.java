package org.goodfood2.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import org.goodfood2.Entity.Adresse_Utilisateur;
import org.goodfood2.utils.QueryUtils;

/**
 * Route liees aux adresses des utilisateurs.
 */
@Path("/Adresse_Utilisateur")
@Tag(name = "Adresse_Utilisateur Resource", description = "L'ensemble des routes pour la partie Adresse_Utilisateur")
public class Adresse_UtilisateurRessource {

    // Permet de gerer les entitees.
    @Inject
    EntityManager entityManager;

    /**
     * Recupere toutes les adresses des utilisateurs.
     * @return Les adresses.
     */
    @Path("/")
    @GET
    public List<Adresse_Utilisateur> adressesUtilisateur() {
        return entityManager.createQuery(
            QueryUtils.makeFindAllQuery("Adresse_Utilisateur"))
                .getResultList();
    }

    /**
     * Cree une adresse d un fournisseur.
     * @param aU L adresse utilisateur.
     * @return Le statut de la reponse.
     */
    @Path("/creer")
    @POST
    @Transactional
    public Response creerAdresseUtilisateur(Adresse_Utilisateur aU) throws Exception {
        entityManager.persist(aU);
        return Response.status(200).build();
    }

    /**
     * Modifie une adresse d un fournisseur.
     * @param aU L adresse utilisateur
     * @return L adresse utilisateur modifiee.
     */
    @Path("/modifier")
    @PATCH
    @Transactional
    public Adresse_Utilisateur modifAdresseUtilisateur(Adresse_Utilisateur aU) throws Exception {
        return entityManager.merge(aU);
    }

    /**
     * Supprime une adresse d un fournisseur.
     * @param id L id de l adresse.
     * @return Le statut de la reponse.
     */
    @Path("/supprimer/{id}")
    @DELETE
    @Transactional
    public Response supprAdresseUtilisateur(@PathParam("id") Long id) throws Exception{
        Adresse_Utilisateur aUtilisateur = (Adresse_Utilisateur)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Adresse_Utilisateur", "id", id.toString()))
                .getResultList().get(0);
        if (aUtilisateur == null) {
            return Response.status(404).build();
        }
        entityManager.remove(aUtilisateur);
        return Response.status(200).build();
    }
}
