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
import org.goodfood2.Entity.Commande;
import org.goodfood2.utils.QueryUtils;

@Path("/Commande")
@Tag(name = "Commande Resource", description = "L'ensemble des routes pour la partie Commande")
public class CommandeResource {
    
    @Inject
    EntityManager entityManager;
    
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Commande> articles() {
        return entityManager.createQuery(
            "select idCommande, dateCommande, totalTtc, statutCommande from Commande")
                .getResultList();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @POST
    @Transactional
    public Response creerCommande(Commande c) throws Exception {
        entityManager.persist(c);
        return Response.status(200).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/modify")
    @PATCH
    @Transactional
    public Commande modifCommande(Commande c) throws Exception {
        return entityManager.merge(c);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete{id}")
    @DELETE
    @Transactional
    public Response supprCommande(@PathParam("id") Long id) throws Exception{
        Commande c = (Commande)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Commande", "id", id.toString()))
                .getResultList().get(0);
        if (c == null) {
            return Response.status(404).build();
        }
        entityManager.remove(c);
        return Response.status(200).build();
    }
}
