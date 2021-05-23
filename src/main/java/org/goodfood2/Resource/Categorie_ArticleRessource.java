package org.goodfood2.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.goodfood2.Entity.Categorie_Article;
import org.goodfood2.utils.QueryUtils;

@Path("/Categorie_Article")
@Tag(name = "Categorie_Article Resource", description = "L'ensemble des routes pour la partie Categorie_Article")
public class Categorie_ArticleRessource {

    @Inject
    EntityManager entityManager;

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/id{id}")
    @GET
    public Categorie_Article categorieArticleId(@PathParam("id") Long id) throws Exception{
        Categorie_Article categorie_Article = (Categorie_Article)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryString("Categorie_Article", "idCategorieArticle", id.toString()))
                .getResultList().get(0);
        return categorie_Article;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/nom{nom}")
    @GET
    public Categorie_Article categorieArticleNom(@PathParam("libelle_categorie_article") String libelle_categorie_article) throws Exception{
        Categorie_Article categorie_Article = (Categorie_Article)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryString("Categorie_Article", "libelleCategorieArticle", libelle_categorie_article))
                .getResultList().get(0);
        return categorie_Article;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Categorie_Article> categorieArticle() {
        return entityManager.createQuery(
            QueryUtils.makeFindAllQuery("Categorie_Article"))
                .getResultList();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @POST
    @Transactional
    public Response creerCategorieArticle(Categorie_Article cA) throws Exception {
        entityManager.persist(cA);
        return Response.status(200).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/modify")
    @PATCH
    @Transactional
    public Categorie_Article modifCategorieArticle(Categorie_Article cA) throws Exception {
        return entityManager.merge(cA);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete{id}")
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
