package org.goodfood2.Resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.goodfood2.Repository.ArticlesRepository;

import io.quarkus.panache.common.Sort;

import org.goodfood2.Entity.Articles;

@Path("/Article")
public class ArticlesResources {
    @Inject
    ArticlesRepository repository;
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getAllArticle")
    @GET
    public List<Articles> articles() {
        
        return Articles.listAll();
    }
    @Path("/addArticle")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveArticle(Articles article){
        article.persist();
        return Response.status(Status.CREATED).entity(article).build();
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/ref={ref}")
    @GET
    public List<Articles> articleRef(@PathParam ("ref") String ref) {
        return repository.findByRef(ref);
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/id={id}")
    @GET
    public List<Articles> articleId(@PathParam ("id")Long  id) {
        return repository.findById(id);
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/tycode={tycode}")
    @GET
    public List<Articles> articleTycode(@PathParam ("tycode") String tycode) {
        return repository.findByTycode(tycode);
    }
    
}
