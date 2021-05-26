package org.goodfood2.Resource;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.DefaultValue;
import java.security.Principal;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.goodfood2.Entity.Article;
import org.goodfood2.Entity.Categorie_Article;
import org.goodfood2.utils.*;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.vertx.web.Header;

import javax.persistence.EntityManager;

@Path("/Article")
@Tag(name = "Article Resource", description = "L'ensemble des routes pour la partie Article")
public class ArticleResource {

    @Inject
    EntityManager entityManager;

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/count")
    @GET
    @Transactional
    @RolesAllowed({ "user", "admin" }) 
    public long countArticle() throws Exception {
        return Article.count();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/ingr/count")
    @GET
    @Transactional
    @RolesAllowed({ "user", "admin" }) 
    public long countIngr() throws Exception {
        return Article.count("from Article obj where estMenu = 0");
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/menu/count")
    @GET
    @Transactional
    @RolesAllowed({ "user", "admin" }) 
    public long countMenu() throws Exception {
        return Article.count("from Article obj where estMenu = 1");
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @GET
    @Transactional
    @RolesAllowed({ "user", "admin" }) 
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
    @RolesAllowed({ "admin" }) 
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
    @RolesAllowed({ "user", "admin" }) 
    public Response creerArticle(@Context SecurityContext sec, Article a) throws Exception {
        Principal user = sec.getUserPrincipal(); 
        entityManager.persist(a);
        return Response.status(200).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/modify")
    @PATCH
    @Transactional
    @RolesAllowed({ "admin" }) 
    public Article modifArticle(Article a) throws Exception {
        return entityManager.merge(a);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    @Transactional
    @PermitAll
    public List<Article> articles(
        @DefaultValue("25") @QueryParam("pageSize") Integer pageSize, 
        @DefaultValue("1") @QueryParam("pageNumber") Integer pageNumber,
        @DefaultValue("") @QueryParam("estMenu") String estMenu,
        @DefaultValue("") @QueryParam("libelleArticle") String libelleArticle,
        @DefaultValue("") @QueryParam("descriptionArticle") String descriptionArticle,
        @DefaultValue("-1") @QueryParam("idCategorieArticle") int idCategorieArticle
    ) { 
        PanacheQuery<Article> articles = null;
        //String query = String.format("FROM Article WHERE estMenu = '%s' AND libelleArticle LIKE '%s' AND LIKE '%s'", estMenu);
        String query = "from Article" + " ";
        query += String.format("where libelleArticle like '%s'","%" + libelleArticle + "%") + " "; 
        query += String.format("and descriptionArticle like '%s'","%" + descriptionArticle + "%") + " "; 

        if(!estMenu.isEmpty())
        {
            query += String.format("and estMenu = '%s'",estMenu) + " "; 
        }

        if (idCategorieArticle > -1) {
            query += String.format("and idCategorieArticle = %d",idCategorieArticle) + " "; 
        }

        query += "and estActive = 1"; 

        articles = Article.find(query);
        System.out.print(query);
        articles.page(Page.ofSize(pageSize));
        for (int i = 0; i < pageNumber - 1; i++){
            articles.nextPage();
        }
        return articles.list();
    }
    
}
