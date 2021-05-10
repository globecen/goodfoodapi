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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.goodfood2.Entity.Article;
import org.goodfood2.utils.*;

import javax.persistence.EntityManager;

@Path("/Article")
public class ArticleResource {

    @Inject
    EntityManager entityManager;

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Article> articles() {
        return entityManager.createQuery(
            QueryUtils.makeFindAllQuery("Article"))
                .getResultList();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @GET
    public Article articleId(@PathParam("id") Long id) throws Exception{
        Article article = (Article)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Article", "id", id.toString()))
                .getResultList().get(0);
        if (article == null) {
            throw new Exception("L'article " + id + " n'existe pas.");
        }    
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
            throw new Exception("L'article " + id + " n'existe pas.");
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


    /*
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/a_pageSize={pageSize}&pageNumber={pageNumber}")
    @GET
    public List<Articles> articlesPagines(@PathParam("pageSize") Integer pageSize,@PathParam("pageNumber") Integer pageNumber) {
        PanacheQuery<Articles> articlesPanacheQuery = Articles.findAll();
        List<Articles> page = articlesPanacheQuery.page(Page.of(pageNumber, pageSize)).list();
        return page;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/m_pageSize={pageSize}&pageNumber={pageNumber}")
    @GET
    public List<Articles> menusPagines(@PathParam("pageSize") Integer pageSize,@PathParam("pageNumber") Integer pageNumber) {
        PanacheQuery<Articles> menusPanacheQuery = Articles.find("tycode", "menu");
        List<Articles> page = menusPanacheQuery.page(Page.of(pageNumber, pageSize)).list();
        return page;
    } */

}
