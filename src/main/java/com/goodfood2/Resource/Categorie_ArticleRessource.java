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

import com.goodfood2.Entity.Categorie_Article;
import com.goodfood2.utils.QueryUtils;

/**
 * Route liees aux categories des articles.
 */
@Path("/Categorie_Article")
@Tag(name = "Categorie_Article Resource", description = "L'ensemble des routes pour la partie Categorie_Article")
public class Categorie_ArticleRessource {

    // Permet de gerer les entitees.
    @Inject
    EntityManager entityManager;

    /**
     * Recupere toutes les categories des articles.
     * 
     * @return Les categories.
     */
    @Path("/")
    @GET
    public List<Categorie_Article> categorieArticle() {
        return entityManager.createQuery(
                QueryUtils.makeFindAllQuery("Categorie_Article"))
                .getResultList();
    }

    /**
     * Cree une categorie .
     * 
     * @param cA La categorie.
     * @return Le statut de la reponse.
     */
    @Path("/creer")
    @POST
    @Transactional
    public Response creerCategorieArticle(Categorie_Article cA) throws Exception {
        entityManager.persist(cA);
        return Response.status(200).build();
    }

    /**
     * Modifie une categorie.
     * 
     * @param a L allergene.
     * @return L adresse fournisseur modifiee.
     */
    @Path("/modifier")
    @PATCH
    @Transactional
    public Categorie_Article modifCategorieArticle(Categorie_Article cA) throws Exception {
        return entityManager.merge(cA);
    }

    /**
     * Supprime une categorie.
     * 
     * @param id L id de la categorie.
     * @return Le statut de la reponse.
     */
    @Path("/supprimer/{id}")
    @DELETE
    @Transactional
    public Response supprCategorieArticle(@PathParam("id") Long id) throws Exception {
        Categorie_Article cArticle = (Categorie_Article) entityManager.createQuery(
                QueryUtils.makeFindByParamQueryInt("Categorie_Article", "id", id.toString()))
                .getResultList().get(0);
        if (cArticle == null) {
            return Response.status(404).build();
        }
        entityManager.remove(cArticle);
        return Response.status(200).build();
    }
}
