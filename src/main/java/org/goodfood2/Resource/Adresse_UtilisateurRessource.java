package org.goodfood2.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

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

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
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

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @POST
    @Transactional
    public Response creerAdresseUtilisateur(Adresse_Utilisateur aU) throws Exception {
        entityManager.persist(aU);
        return Response.status(200).build();
    }
}
