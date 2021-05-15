package org.goodfood2.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.goodfood2.Entity.Franchise;

@Path("/Franchise")
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
}
