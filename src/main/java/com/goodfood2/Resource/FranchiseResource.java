package com.goodfood2.Resource;

import java.util.List;

import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.goodfood2.Entity.Franchise;
import com.goodfood2.utils.QueryUtils;

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
     * 
     * @param search La recherche.
     * @return La liste des franchises.
     */
    @Path("/")
    @GET
    @PermitAll
    public List<Franchise> franchises(@DefaultValue("") @QueryParam("search") String search) {
        if (search.isEmpty())
            return entityManager.createQuery("from Franchise").getResultList();
        else {
            String b_emailFranchise, a_idFranchise, c_idGroupeFranchise, d_nomFranchise, e_numeroSiretFranchise,
                    f_numeroTelFranchise;
            b_emailFranchise = "b_emailFranchise like '" + search + "' or ";
            a_idFranchise = "a_idFranchise like '" + search + "' or ";
            c_idGroupeFranchise = "c_idGroupeFranchise like '" + search + "' or ";
            d_nomFranchise = "d_nomFranchise like '%" + search + "%' or ";
            e_numeroSiretFranchise = "e_numeroSiretFranchise like '" + search + "' or ";
            f_numeroTelFranchise = "f_numeroTelFranchise like '" + search + "'";
            return entityManager.createQuery("from Franchise  where " + b_emailFranchise + a_idFranchise
                    + c_idGroupeFranchise + d_nomFranchise + e_numeroSiretFranchise + f_numeroTelFranchise)
                    .getResultList();
        }
    }

    /**
     * Cree une franchise .
     * 
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
     * 
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
     * 
     * @param id L id de la franchise.
     * @return Le statut de la reponse.
     */
    @Path("/supprimer/{id}")
    @DELETE
    @Transactional
    public Response supprFranchise(@PathParam("id") Long id) throws Exception {
        Franchise f = (Franchise) entityManager.createQuery(
                QueryUtils.makeFindByParamQueryInt("Franchise", "id", id.toString()))
                .getResultList().get(0);
        if (f == null) {
            return Response.status(404).build();
        }
        entityManager.remove(f);
        return Response.status(200).build();
    }
}
