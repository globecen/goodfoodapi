package org.goodfood2.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.goodfood2.utils.QueryUtils;
import org.goodfood2.Entity.Commande;

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
     * @param idUtilisateur L id de l utilisateur.
     * @return Les commandes.
     */
    @Path("/")
    @GET
    public List<Commande> articles(
        @DefaultValue("-1") @QueryParam("idUtilisateur") Integer idUtilisateur
    ) {
        String query = "FROM Commande c";
        
        if(idUtilisateur > -1){
            query += " WHERE c.idUtilisateur = " + idUtilisateur;
        }

        return entityManager.createQuery(query).getResultList();
    }

    /**
     * Cree une commande .
     * @param c La commande.
     * @return L id de la commande necessaire pour creer les lignes.
     */
    @Path("/creer")
    @POST
    public int creerCommande(Commande c) throws Exception {
        entityManager.persist(c);
        return c.getIdCommande();
    }

    /**
     * Modifie une commande.
     * @param c La commande.
     * @return La commande modifiee.
     */
    @Path("/modifier")
    @PATCH
    public Commande modifCommande(Commande c) throws Exception {
        return entityManager.merge(c);
    }

    /**
     * Supprime une commande.
     * @param id L id de la commande.
     * @return Le statut de la reponse.
     */
    @Path("/supprimer/{id}")
    @DELETE
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
