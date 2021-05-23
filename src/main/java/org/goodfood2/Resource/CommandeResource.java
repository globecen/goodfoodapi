package org.goodfood2.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.goodfood2.Entity.Commande;
import org.goodfood2.Entity.Ligne_Commande;

@Path("/Commande")
@Tag(name = "Commande Resource", description = "L'ensemble des routes pour la partie Commande")
public class CommandeResource {
    
    @Inject
    EntityManager entityManager;
    
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Commande> articles(
        @DefaultValue("-1") @QueryParam("idUtilisateur") Integer idUtilisateur
    ) {
        String query = "FROM Commande";
        
        if(idUtilisateur > -1){
            query += " WHERE utilisateur.idUtilisateur = " + idUtilisateur;
        }

        return entityManager.createQuery(query).getResultList();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @POST
    @Transactional
    public Commande creerCommande(Commande c) throws Exception {
        try {
            entityManager.persist(c);
            entityManager.flush();
            entityManager.refresh(c);
            return c;
        } catch (Exception e) {
            Response.status(500).build();
            return c;
        }

    }
}
