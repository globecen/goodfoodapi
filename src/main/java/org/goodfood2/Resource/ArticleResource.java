package org.goodfood2.Resource;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.DefaultValue;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.goodfood2.Entity.Article;
import org.goodfood2.utils.*;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import javax.persistence.EntityManager;

@Path("/Article")
@Tag(name = "Article Resource", description = "L'ensemble des routes pour la partie Article")
public class ArticleResource {

    @Inject
    EntityManager entityManager;

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Article> articles(
        @DefaultValue("25") @QueryParam("pageSize") Integer pageSize, 
        @DefaultValue("1") @QueryParam("pageNumber") Integer pageNumber,
        @DefaultValue("") @QueryParam("estMenu") String estMenu,
        @DefaultValue("") @QueryParam("libelleArticle") String libelleArticle,
        @DefaultValue("") @QueryParam("descriptionArticle") String descriptionArticle
        ) {
            
        PanacheQuery<Article> articles = null;
        if (estMenu.equals(""))
            articles = Article.find(
                "From Article where libelleArticle like '%" + libelleArticle + "%' and descriptionArticle like '%" + descriptionArticle + "%'");
        else 
            articles = Article.find(
                "From Article where estMenu = '" + estMenu + "' and libelleArticle like '%" + libelleArticle + "%' and descriptionArticle like '%" + descriptionArticle + "%'");
        articles.page(Page.ofSize(pageSize));
        for (int i = 0; i < pageNumber - 1; i++){
            articles.nextPage();
        }
        return articles.list();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/count")
    @GET
    @Transactional
    public long countArticle() throws Exception {
        return Article.count();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/ingr/count")
    @GET
    @Transactional
    public long countIngr() throws Exception {
        return Article.count("from Article obj where estMenu = 0");
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/menu/count")
    @GET
    @Transactional
    public long countMenu() throws Exception {
        return Article.count("from Article obj where estMenu = 1");
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/id{id}")
    @GET
    public Article articleId(@PathParam("id") Long id) throws Exception{
        Article article = (Article)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Article", "id", id.toString()))
                .getResultList().get(0);
        return article;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete{id}")
    @DELETE
    @Transactional
    public Response supprArticle(@PathParam("id") Long id) throws Exception{
        Article article = (Article)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Article", "id", id.toString()))
                .getResultList().get(0);
        if (article == null) {
            return Response.status(404).build();
        }
        entityManager.remove(article);
        return Response.status(200).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @POST
    @Transactional
    public Response creerArticle(Article a) throws Exception {
        entityManager.persist(a);
        return Response.status(200).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/modify")
    @PATCH
    @Transactional
    public Article modifArticle(Article a) throws Exception {
        return entityManager.merge(a);
    }
}
