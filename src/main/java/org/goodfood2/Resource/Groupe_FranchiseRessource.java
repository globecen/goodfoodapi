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
import org.goodfood2.Entity.Groupe_Franchise;
import org.goodfood2.utils.QueryUtils;

@Path("/Groupe_Franchise")
@Tag(name = "Groupe_Franchise Resource", description = "L'ensemble des routes pour la partie Groupe_Franchise")
public class Groupe_FranchiseRessource {
  
    @Inject
    EntityManager entityManager;
  
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Groupe_Franchise> groupesfranchise() {
        return entityManager.createQuery(
            QueryUtils.makeFindAllQuery("Groupe_Franchise"))
                .getResultList();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @POST
    @Transactional
    public Response creerGroupeFranchise(Groupe_Franchise gF) throws Exception {
        entityManager.persist(gF);
        return Response.status(200).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/modify")
    @PATCH
    @Transactional
    public Groupe_Franchise modifGroupeFranchise(Groupe_Franchise gF) throws Exception {
        return entityManager.merge(gF);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete{id}")
    @DELETE
    @Transactional
    public Response supprGroupeFranchise(@PathParam("id") Long id) throws Exception{
        Groupe_Franchise gFranchise = (Groupe_Franchise)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Groupe_Franchise", "id", id.toString()))
                .getResultList().get(0);
        if (gFranchise == null) {
            return Response.status(404).build();
        }
        entityManager.remove(gFranchise);
        return Response.status(200).build();
    }
}