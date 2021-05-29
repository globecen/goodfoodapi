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
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.goodfood2.Entity.Adresse_Utilisateur;
import org.goodfood2.utils.QueryUtils;

@Path("/Adresse_Utilisateur")
@Tag(name = "Adresse_Utilisateur Resource", description = "L'ensemble des routes pour la partie Adresse_Utilisateur")
public class Adresse_UtilisateurRessource {

    @Inject
    EntityManager entityManager;

    @Path("/")
    @GET
    public List<Adresse_Utilisateur> adressesUtilisateur(   
        @DefaultValue("-1") @QueryParam("idUtilisateur") Integer idUtilisateur
    ) {
        String query = QueryUtils.makeFindAllQuery("Adresse_Utilisateur");
        System.out.println(idUtilisateur < 0);
        if(idUtilisateur > -1){
            query += " where obj.idUtilisateur = " + idUtilisateur;
        }
        return entityManager.createQuery(query).getResultList();
    }

    @Path("/create")
    @POST
    @Transactional
    public Response creerAdresseUtilisateur(Adresse_Utilisateur aU) throws Exception {
        entityManager.persist(aU);
        return Response.status(200).build();
    }

    @Path("/modify")
    @PATCH
    @Transactional
    public Adresse_Utilisateur modifAdresseUtilisateur(Adresse_Utilisateur aU) throws Exception {
        return entityManager.merge(aU);
    }

    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public Response supprAdresseUtilisateur(@PathParam("id") Long id) throws Exception{
        Adresse_Utilisateur aUtilisateur = (Adresse_Utilisateur)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Adresse_Utilisateur", "id", id.toString()))
                .getResultList().get(0);
        if (aUtilisateur == null) {
            return Response.status(404).build();
        }
        entityManager.remove(aUtilisateur);
        return Response.status(200).build();
    }
}
