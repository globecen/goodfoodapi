package org.goodfood2.Resource;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import org.goodfood2.Entity.Article;
import org.goodfood2.utils.*;

import javax.inject.Inject;
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
                .setMaxResults(25)
                .getResultList();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @GET
    public Article articleId(@PathParam("id") Long id) {
        return (Article)entityManager.createQuery(
            QueryUtils.makeFindByIdQuery("Article", id, "id_article"))
                .setMaxResults(1)
                .getResultList().get(0);
    }

/* 
    @Path("/modifyArticleById={id}")
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void modifyArticle(@PathParam("id") Long id) {
 
    }

    @Path("/deleteArticleById={id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void deleteArticle(@PathParam("id") Long id) {
        Articles.delete("id", id);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/ref={ref}")
    @GET
    public List<Articles> articleRef(@PathParam("ref") String ref) {
        return repository.findByRef(ref);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/id={id}")
    @GET
    public List<Articles> articleId(@PathParam("id") Long id) {
        return Articles.find("id", id).list();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/tycode={tycode}")
    @GET
    public List<Articles> articleTycode(@PathParam("tycode") String tycode) {
        return repository.findByTycode(tycode);
    }

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
