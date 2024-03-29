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

import com.goodfood2.Entity.Promo;
import com.goodfood2.utils.QueryUtils;

/**
 * Route liees aux promotions.
 */
@Path("/Promo")
@Tag(name = "Promo Resource", description = "L'ensemble des routes pour la partie Promo")
public class PromoResource {

    // Permet de gerer les entitees.
    @Inject
    EntityManager entityManager;

    /**
     * Recupere toutes les promotions.
     * 
     * @return Les promotions.
     */
    @Path("/")
    @GET
    public List<Promo> promos() {
        return entityManager.createQuery(
                QueryUtils.makeFindAllQuery("Promo"))
                .getResultList();
    }

    /**
     * Cree une promotion.
     * 
     * @param p La promotion.
     * @return Le statut de la reponse.
     */
    @Path("/creer")
    @POST
    @Transactional
    public Response creerPromo(Promo p) throws Exception {
        entityManager.persist(p);
        return Response.status(200).build();
    }

    /**
     * Modifie une promotion.
     * 
     * @param p La promotion.
     * @return La promotion modifie.
     */
    @Path("/modifier")
    @PATCH
    @Transactional
    public Promo modifPromo(Promo p) throws Exception {
        return entityManager.merge(p);
    }

    /**
     * Supprime une promotion.
     * 
     * @param id L id de la promotion.
     * @return Le statut de la reponse.
     */
    @Path("/supprimer/{id}")
    @DELETE
    @Transactional
    public Response supprPromo(@PathParam("id") Long id) {
        Promo promo = (Promo) entityManager.createQuery(
                QueryUtils.makeFindByParamQueryInt("Promo", "id", id.toString()))
                .getResultList().get(0);
        if (promo == null) {
            return Response.status(404).build();
        }
        entityManager.remove(promo);
        return Response.status(200).build();
    }

    /**
     * Recupere une promotion.
     * 
     * @param id L id de la promotion.
     * @return La promotion.
     */
    @Path("/{id}")
    @GET
    public Promo promoId(@PathParam("id") Long id) throws Exception {
        Promo promo = (Promo) entityManager.createQuery(
                QueryUtils.makeFindByParamQueryInt("Promo", "id", id.toString()))
                .getResultList().get(0);
        return promo;
    }

}