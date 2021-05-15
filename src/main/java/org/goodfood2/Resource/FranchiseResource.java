package org.goodfood2.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.goodfood2.Entity.Franchise;

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
}
