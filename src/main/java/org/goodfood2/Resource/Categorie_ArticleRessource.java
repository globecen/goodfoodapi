package org.goodfood2.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.goodfood2.Entity.Categorie_Article;
import org.goodfood2.utils.QueryUtils;

@Path("/Categorie_Article")
public class Categorie_ArticleRessource {
    @Inject
    EntityManager entityManager;
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/id{id}")
    @GET
    public Categorie_Article categorie_ArticleId(@PathParam("id") Long id) throws Exception{
        Categorie_Article categorie_Article = (Categorie_Article)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryString("Categorie_Article", "idCategorieArticle", id.toString()))
                .getResultList().get(0);
        if (categorie_Article == null) {
            throw new Exception("La categorie d'article " + id + " n'existe pas.");
        }    
        return categorie_Article;
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/nom{nom}")
    @GET
    public Categorie_Article categorie_ArticleNom(@PathParam("libelle_categorie_article") String libelle_categorie_article) throws Exception{
        Categorie_Article categorie_Article = (Categorie_Article)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryString("Categorie_Article", "libelleCategorieArticle", libelle_categorie_article))
                .getResultList().get(0);
        if (categorie_Article == null) {
            throw new Exception("La categorie d'article " + libelle_categorie_article + " n'existe pas.");
        }    
        return categorie_Article;
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Categorie_Article> categorie_Article() {
        return entityManager.createQuery(
            QueryUtils.makeFindAllQuery("Categorie_Article"))
                .getResultList();
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @POST
    @Transactional
    public Response creerCommande(Categorie_Article ca) throws Exception {
        entityManager.persist(ca);
        return Response.status(200).build();
    }
}
