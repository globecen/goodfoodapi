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
import org.goodfood2.Entity.Franchise;
import org.goodfood2.utils.QueryUtils;

@Path("/Franchise")
@Tag(name = "Franchise Resource", description = "L'ensemble des routes pour la partie Franchise")
public class FranchiseResource {
    
    @Inject
    EntityManager entityManager;

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Franchise> franchises() {
        return entityManager.createQuery("select emailFranchise, idFranchise, idGroupeFranchise, nomFranchise, numeroSiretFranchise, numeroTelFranchise from Franchise").getResultList();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @POST
    @Transactional
    public Response creerFranchise(Franchise f) throws Exception {
        entityManager.persist(f);
        return Response.status(200).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/modify")
    @PATCH
    @Transactional
    public Franchise modifFranchise(Franchise f) throws Exception {
        return entityManager.merge(f);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete{id}")
    @DELETE
    @Transactional
    public Response supprFranchise(@PathParam("id") Long id) throws Exception{
        Franchise f = (Franchise)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Franchise", "id", id.toString()))
                .getResultList().get(0);
        if (f == null) {
            return Response.status(404).build();
        }
        entityManager.remove(f);
        return Response.status(200).build();
    }
}
