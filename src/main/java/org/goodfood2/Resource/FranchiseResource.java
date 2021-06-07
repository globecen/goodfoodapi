package org.goodfood2.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.annotation.security.PermitAll;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import org.goodfood2.Entity.Franchise;
import org.goodfood2.utils.QueryUtils;

/**
 * Route liees aux franchises.
 */
@Path("/Franchise")
@Tag(name = "Franchise Resource", description = "L'ensemble des routes pour la partie Franchise")
public class FranchiseResource {
    
    // Permet de gerer les entitees.
    @Inject
    EntityManager entityManager;

    /**
     * Recupere la liste des franchises en fonctions de la recherche.
     * @param search La recherche.
     * @return La liste des franchises.
     */
    @Path("/")
    @GET
    @PermitAll
    public List<Franchise> franchises(@DefaultValue("") @QueryParam("search") String search) {
        if(search.isEmpty())
            return entityManager.createQuery("from Franchise").getResultList();
        else {
            String emailFranchise, idFranchise, idGroupeFranchise, nomFranchise, numeroSiretFranchise, numeroTelFranchise;
            emailFranchise = "b_emailFranchise like '" + search + "' or ";
            idFranchise = "a_idFranchise like '" + search + "' or ";
            idGroupeFranchise = "c_idGroupeFranchise like '" + search + "' or ";
            nomFranchise = "d_nomFranchise like '%" + search + "%' or ";
            numeroSiretFranchise = "e_numeroSiretFranchise like '" + search + "' or ";
            numeroTelFranchise = "f_numeroTelFranchise like '" + search + "'";
            return entityManager.createQuery("from Franchise  where " + emailFranchise + idFranchise + idGroupeFranchise + nomFranchise + numeroSiretFranchise + numeroTelFranchise).getResultList();
        }
    }

    /**
     * Cree une franchise .
     * @param f La franchise.
     * @return Le statut de la reponse.
     */
    @Path("/creer")
    @POST
    @Transactional
    public Response creerFranchise(Franchise f) throws Exception {
        entityManager.persist(f);
        return Response.status(200).build();
    }

     /**
     * Modifie une franchise.
     * @param f La franchise.
     * @return La franchise modifie.
     */
    @Path("/modifier")
    @PATCH
    @Transactional
    public Franchise modifFranchise(Franchise f) throws Exception {
        return entityManager.merge(f);
    }

    /**
     * Supprime une franchise.
     * @param id L id de la franchise.
     * @return Le statut de la reponse.
     */
    @Path("/supprimer/{id}")
    @DELETE
    @Transactional
    public Response supprFranchise(@PathParam("id") Long id) throws Exception{
        Franchise f = (Franchise)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Franchise", "id", id.toString()))
                .getResultList().get(0);
        if (f == null) {
            return Response.status(404).build();
        }
        entityManager.remove(f);
        return Response.status(200).build();
    }
}
