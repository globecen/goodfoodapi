package org.goodfood2.Resource;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.goodfood2.Entity.Commande;
import org.goodfood2.utils.QueryUtils;
import org.h2.util.ToChar;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;

@Path("/Commande")
@Tag(name = "Commande Resource", description = "L'ensemble des routes pour la partie Commande")
public class CommandeResource {
    
    @Inject
    EntityManager entityManager;
    
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Commande> commandes(
        @DefaultValue("25") @QueryParam("pageSize") Integer pageSize, 
        @DefaultValue("1") @QueryParam("pageNumber") Integer pageNumber,
        @QueryParam("dateCommande") Timestamp dateCommande,
        @DefaultValue("1") @QueryParam("statutCommande") int statutCommande
        ) {
        PanacheQuery<Commande> commandes = null;
        if (dateCommande == null){
            commandes = Commande.find(
                "select idCommande, dateCommande, totalTtc, statutCommande from Commande where statutCommande = " + statutCommande 
            );
        }
        else { 
            commandes = Commande.find(
                "select idCommande, dateCommande, totalTtc, statutCommande from Commande where statutCommande = " + statutCommande + " and extract(day from dateCommande) = extract(day from '" + dateCommande +"')"
            );
        }    
        commandes.page(Page.ofSize(pageSize));
        for (int i = 0; i < pageNumber - 1; i++){
            commandes.nextPage();
        }
        return commandes.list();
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
