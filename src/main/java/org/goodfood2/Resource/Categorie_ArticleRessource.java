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

import org.goodfood2.Entity.Categorie_Article;
import org.goodfood2.utils.QueryUtils;

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
     * @param cA La categorie.
     * @return Le statut de la reponse.
     */
    @Path("/create")
    @POST
    @Transactional
    public Response creerCategorieArticle(Categorie_Article cA) throws Exception {
        entityManager.persist(cA);
        return Response.status(200).build();
    }

    /**
     * Modifie une categorie.
     * @param a L allergene.
     * @return L adresse fournisseur modifiee.
     */
    @Path("/modify")
    @PATCH
    @Transactional
    public Categorie_Article modifCategorieArticle(Categorie_Article cA) throws Exception {
        return entityManager.merge(cA);
    }

    /**
     * Supprime une categorie.
     * @param id L id de la categorie.
     * @return Le statut de la reponse.
     */
    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public Response supprCategorieArticle(@PathParam("id") Long id) throws Exception{
        Categorie_Article cArticle = (Categorie_Article)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Categorie_Article", "id", id.toString()))
                .getResultList().get(0);
        if (cArticle == null) {
            return Response.status(404).build();
        }
        entityManager.remove(cArticle);
        return Response.status(200).build();
    }
}
