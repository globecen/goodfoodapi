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
import org.goodfood2.Entity.Ligne_Commande;
import org.goodfood2.utils.QueryUtils;

@Path("/Ligne_Commande")
@Tag(name = "Ligne_Commande Resource", description = "L'ensemble des routes pour la partie Ligne_Commande")
public class Ligne_CommandeResource {

    @Inject
    EntityManager entityManager;

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Ligne_Commande> lignesCommande() {
        return entityManager.createQuery(
            QueryUtils.makeFindAllQuery("Ligne_Commande"))
                .getResultList();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @POST
    @Transactional
    public Response creerLigneCommande(Ligne_Commande[] lC) throws Exception {
        try {
            for (Ligne_Commande ligne_Commande : lC) {
                entityManager.persist(ligne_Commande);
            }
            return Response.status(200).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }

    }
}