package com.goodfood2.Resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.goodfood2.Entity.Ligne_Commande;
import com.goodfood2.utils.QueryUtils;

/**
 * Route liees aux lignes de commandes.
 */
@Path("/Ligne_Commande")
@Tag(name = "Ligne_Commande Resource", description = "L'ensemble des routes pour la partie Ligne_Commande")
public class Ligne_CommandeResource {

    // Permet de gerer les entitees.
    @Inject
    EntityManager entityManager;

    /**
     * Recupere toutes les lignes de commande.
     * 
     * @return Les lignes de commande.
     */
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Ligne_Commande> lignesCommande() {
        return entityManager.createQuery(
                QueryUtils.makeFindAllQuery("Ligne_Commande"))
                .getResultList();
    }

    /**
     * Cree des lignes de commande.
     * 
     * @param lC Les lignes de commande.
     * @return Le statut de la reponse.
     */
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/creer")
    @POST
    @Transactional
    public Response creerLignesCommande(Ligne_Commande[] lC) throws Exception {
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