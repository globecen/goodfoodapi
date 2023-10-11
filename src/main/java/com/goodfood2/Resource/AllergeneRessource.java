package com.goodfood2.Resource;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.goodfood2.Entity.Allergene;
import com.goodfood2.utils.QueryUtils;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

/**
 * Route liees aux allergenes.
 */
@jakarta.ws.rs.Path("/Allergene")
@Tag(name = "Allergene Resource", description = "L'ensemble des routes pour la partie Allergene")
public class AllergeneRessource {

    // Permet de gerer les entitees.
    @jakarta.inject.Inject
    EntityManager entityManager;

    /**
     * Recupere toutes les allergenes des utilisateurs.
     * 
     * @return Les allergenes.
     */
    @Path("/")
    @GET
    public List<Allergene> allergenes() {
        return entityManager.createQuery(
                QueryUtils.makeFindAllQuery("Allergene"))
                .getResultList();
    }

    /**
     * Cree un allergene.
     * 
     * @param a L allergene.
     * @return Le statut de la reponse.
     */
    @Path("/creer")
    @POST
    @Transactional
    public Response creerAllergene(Allergene a) throws Exception {
        entityManager.persist(a);
        return Response.status(200).build();
    }

    /**
     * Modifie un allergene.
     * 
     * @param a L allergene.
     * @return L adresse fournisseur modifiee.
     */
    @Path("/modifier")
    @PATCH
    @Transactional
    public Allergene modifAllergene(Allergene a) throws Exception {
        return entityManager.merge(a);
    }

    /**
     * Supprime un allergene.
     * 
     * @param id L id de l allergene.
     * @return Le statut de la reponse.
     */
    @Path("/supprimer/{id}")
    @DELETE
    @Transactional
    public Response supprAllergene(@PathParam("id") Long id) throws Exception {
        Allergene a = (Allergene) entityManager.createQuery(
                QueryUtils.makeFindByParamQueryInt("Allergene", "id", id.toString()))
                .getResultList().get(0);
        if (a == null) {
            return Response.status(404).build();
        }
        entityManager.remove(a);
        return Response.status(200).build();
    }
}
