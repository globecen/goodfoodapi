package com.goodfood2.Resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.goodfood2.Entity.Adresse_Fournisseur;
import com.goodfood2.utils.QueryUtils;

/**
 * Route liees aux adresses des fournisseurs.
 */
@Path("/Adresse_Fournisseur")
@Tag(name = "Adresse_Fournisseur Resource", description = "L'ensemble des routes pour la partie Adresse_Fournisseur")
public class Adresse_FournisseurRessource {

    // Permet de gerer les entitees.
    @Inject
    EntityManager entityManager;

    /**
     * Recupere toutes les adresses des fournisseurs.
     * 
     * @return Les adresses.
     */
    @Path("/")
    @GET
    public List<Adresse_Fournisseur> adressesFournisseur() {
        return entityManager.createQuery(
                QueryUtils.makeFindAllQuery("Adresse_Fournisseur"))
                .getResultList();
    }

    /**
     * Cree une adresse d un fournisseur.
     * 
     * @param aF L adresse fournisseur.
     * @return Le statut de la reponse.
     */
    @Path("/creer")
    @POST
    @Transactional
    public Response creerAdresseFournisseur(Adresse_Fournisseur aF) throws Exception {
        entityManager.persist(aF);
        return Response.status(200).build();
    }

    /**
     * Modifie une adresse d un fournisseur.
     * 
     * @param aF L adresse fournisseur.
     * @return L adresse fournisseur modifiee.
     */
    @Path("/modifier")
    @PATCH
    @Transactional
    public Adresse_Fournisseur modifAdresseFournisseur(Adresse_Fournisseur aF) throws Exception {
        return entityManager.merge(aF);
    }

    /**
     * Supprime une adresse d un fournisseur.
     * 
     * @param id L id de l adresse.
     * @return Le statut de la reponse.
     */
    @Path("/supprimer/{id}")
    @DELETE
    @Transactional
    public Response supprAdresseFournisseur(@PathParam("id") Long id) throws Exception {
        Adresse_Fournisseur aFournisseur = (Adresse_Fournisseur) entityManager.createQuery(
                QueryUtils.makeFindByParamQueryInt("Adresse_Fournisseur", "id", id.toString()))
                .getResultList().get(0);
        if (aFournisseur == null) {
            return Response.status(404).build();
        }
        entityManager.remove(aFournisseur);
        return Response.status(200).build();
    }
}