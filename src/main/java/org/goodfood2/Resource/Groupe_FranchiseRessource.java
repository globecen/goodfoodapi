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
}