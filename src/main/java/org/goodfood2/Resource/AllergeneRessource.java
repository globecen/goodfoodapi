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

import org.goodfood2.Entity.Allergene;
import org.goodfood2.Entity.Commande;
import org.goodfood2.utils.QueryUtils;

@Path("/Allergene")
public class AllergeneRessource {
  
    @Inject
    EntityManager entityManager;
  
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Allergene> allergenes() {
        return entityManager.createQuery(
            QueryUtils.makeFindAllQuery("Allergene"))
                .getResultList();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @POST
    @Transactional
    public Response creerAllergene(Allergene a) throws Exception {
        entityManager.persist(a);
        return Response.status(200).build();
    }
}