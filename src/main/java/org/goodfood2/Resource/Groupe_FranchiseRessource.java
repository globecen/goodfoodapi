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

import org.goodfood2.Entity.Groupe_Franchise;
import org.goodfood2.utils.QueryUtils;

/**
 * Route liees aux groupes de franchises.
 */
@Path("/Groupe_Franchise")
@Tag(name = "Groupe_Franchise Resource", description = "L'ensemble des routes pour la partie Groupe_Franchise")
public class Groupe_FranchiseRessource {
    
    // Permet de gerer les entitees.
    @Inject
    EntityManager entityManager;

    /**
     * Recupere tous les groupes de franchises.
     * @return Les groupes de franchises.
     */
    @Path("/")
    @GET
    public List<Groupe_Franchise> groupesfranchise() {
        return entityManager.createQuery(
            QueryUtils.makeFindAllQuery("Groupe_Franchise"))
                .getResultList();
    }

    /**
     * Cree un groupe de franchises.
     * @param gF Le groupe de franchise.
     * @return Le statut de la reponse.
     */
    @Path("/create")
    @POST
    @Transactional
    public Response creerGroupeFranchise(Groupe_Franchise gF) throws Exception {
        entityManager.persist(gF);
        return Response.status(200).build();
    }

    /**
     * Modifie un groupe de franchises.
     * @param gf Le groupe de franchises.
     * @return Le groupe de franchises modifie.
     */
    @Path("/modify")
    @PATCH
    @Transactional
    public Groupe_Franchise modifGroupeFranchise(Groupe_Franchise gF) throws Exception {
        return entityManager.merge(gF);
    }

    /**
     * Supprime un groupe de franchises.
     * @param id L id du groupe de franchises.
     * @return Le statut de la reponse.
     */
    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public Response supprGroupeFranchise(@PathParam("id") Long id) throws Exception{
        Groupe_Franchise gFranchise = (Groupe_Franchise)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Groupe_Franchise", "id", id.toString()))
                .getResultList().get(0);
        if (gFranchise == null) {
            return Response.status(404).build();
        }
        entityManager.remove(gFranchise);
        return Response.status(200).build();
    }
}