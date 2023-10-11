package com.goodfood2.Resource;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import com.goodfood2.utils.QueryUtils;
import com.goodfood2.Entity.Commande;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * Route liees aux commandes.
 */
@Path("/Commande")
@Tag(name = "Commande Resource", description = "L'ensemble des routes pour la partie Commande")
public class CommandeResource {

    // Permet de gerer les entitees.
    @Inject
    EntityManager entityManager;

    /**
     * Recupere toutes les commandes d un utilisateur.
     * 
     * @param idUtilisateur L id de l utilisateur.
     * @return Les commandes.
     */
    @Path("/")
    @GET
    public List<Commande> articles(@DefaultValue("-1") @QueryParam("idUtilisateur") Integer idUtilisateur) {
        String query = "from Commande c";

        if (idUtilisateur > -1) {
            query += " where c.b_idUtilisateur = " + idUtilisateur;
        }

        return entityManager.createQuery(query).getResultList();
    }

    /**
     * Cree une commande .
     * 
     * @param c La commande.
     * @return L id de la commande necessaire pour creer les lignes.
     */
    @Path("/creer")
    @POST
    @Transactional
    public int creerCommande(Commande c) throws Exception {
        entityManager.persist(c);
        return c.getA_idCommande();
    }

    /**
     * Modifie une commande.
     * 
     * @param c La commande.
     * @return La commande modifiee.
     */
    @Path("/modifier")
    @PATCH
    @Transactional
    public Commande modifCommande(Commande c) throws Exception {
        return entityManager.merge(c);
    }

    /**
     * Supprime une commande.
     * 
     * @param id L id de la commande.
     * @return Le statut de la reponse.
     */
    @Path("/supprimer/{id}")
    @DELETE
    @Transactional
    public Response supprCommande(@PathParam("id") Long id) throws Exception {
        Commande c = (Commande) entityManager
                .createQuery(QueryUtils.makeFindByParamQueryInt("Commande", "id", id.toString())).getResultList()
                .get(0);
        if (c == null) {
            return Response.status(404).build();
        }
        entityManager.remove(c);
        return Response.status(200).build();
    }
}
