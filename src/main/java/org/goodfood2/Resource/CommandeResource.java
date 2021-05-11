package org.goodfood2.Resource;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.goodfood2.Entity.Article;
import org.goodfood2.Entity.Commande;

@Path("/Commande")
public class CommandeResource {
    
    @Inject
    EntityManager entityManager;
    
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @POST
    @Transactional
    public Response creerCommande(Commande c) throws Exception {
        entityManager.persist(c);
        return Response.status(200).build();
    }
}
