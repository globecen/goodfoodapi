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
import org.goodfood2.Entity.Promo;
import org.goodfood2.utils.QueryUtils;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;

@Path("/Promo")
@Tag(name = "Promo Resource", description = "L'ensemble des routes pour la partie Promo")
public class PromoResource {
  
    @Inject
    EntityManager entityManager;
  
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Promo> lignesCommande() {
        return entityManager.createQuery(
            QueryUtils.makeFindAllQuery("Promo"))
                .getResultList();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @POST
    @Transactional
    public Response creerPromo(Promo p) throws Exception {
        entityManager.persist(p);
        return Response.status(200).build();
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/modify")
    @PATCH
    @Transactional
    public Promo modifPromo(Promo p) throws Exception {
        return entityManager.merge(p);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete{id}")
    @DELETE
    @Transactional
    public Response supprPromo(@PathParam("id") Long id){
        Promo promo = (Promo)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Promo", "id", id.toString()))
                .getResultList().get(0);
        if (promo == null) {
            return Response.status(404).build();
        }
        entityManager.remove(promo);
        return Response.status(200).build();
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/id{id}")
    @GET
    public Promo promoId(@PathParam("id") Long id) throws Exception{
        Promo promo = (Promo)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Promo", "id", id.toString()))
                .getResultList().get(0);
        return promo;
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/p_pageSize={pageSize}&pageNumber={pageNumber}")
    @GET
    public List<Promo> promosPagines(@PathParam("pageSize") Integer pageSize,@PathParam("pageNumber") Integer pageNumber) {
        PanacheQuery<Promo> promos = Promo.findAll();
        promos.page(Page.ofSize(pageSize));
        for (int i = 0; i < pageNumber - 1; i++){
            promos.nextPage();
        }
        return promos.list();
    }
}