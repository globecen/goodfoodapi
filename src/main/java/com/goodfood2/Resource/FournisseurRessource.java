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

import com.goodfood2.Entity.Fournisseur;
import com.goodfood2.utils.QueryUtils;

/**
 * Route liees aux fournisseurs.
 */
@Path("/Fournisseur")
@Tag(name = "Fournisseur Resource", description = "L'ensemble des routes pour la partie Fournisseur")
public class FournisseurRessource {

    // Permet de gerer les entitees.
    @Inject
    EntityManager entityManager;

    /**
     * Recupere tous les fournisseurs.
     * 
     * @return Les fournisseurs.
     */
    @Path("/")
    @GET
    public List<Fournisseur> adressesUtilisateur() {
        return entityManager.createQuery(
                QueryUtils.makeFindAllQuery("Fournisseur"))
                .getResultList();
    }

    /**
     * Cree un fournisseur .
     * 
     * @param f Le fournisseur.
     * @return Le statut de la reponse.
     */
    @Path("/creer")
    @POST
    @Transactional
    public Response creerFournisseur(Fournisseur f) throws Exception {
        entityManager.persist(f);
        return Response.status(200).build();
    }

    /**
     * Modifie un fournisseur.
     * 
     * @param f Le fournisseur.
     * @return Le fournisseur modifie.
     */
    @Path("/modifier")
    @PATCH
    @Transactional
    public Fournisseur modifFournisseur(Fournisseur f) throws Exception {
        return entityManager.merge(f);
    }

    /**
     * Supprime un fournisseur.
     * 
     * @param id L id du fournisseur.
     * @return Le statut de la reponse.
     */
    @Path("/supprimer/{id}")
    @DELETE
    @Transactional
    public Response supprFournisseur(@PathParam("id") Long id) throws Exception {
        Fournisseur f = (Fournisseur) entityManager.createQuery(
                QueryUtils.makeFindByParamQueryInt("Fournisseur", "id", id.toString()))
                .getResultList().get(0);
        if (f == null) {
            return Response.status(404).build();
        }
        entityManager.remove(f);
        return Response.status(200).build();
    }
}