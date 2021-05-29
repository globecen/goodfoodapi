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
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.goodfood2.Entity.Adresse_Fournisseur;
import org.goodfood2.utils.QueryUtils;

@Path("/Adresse_Fournisseur")
@Tag(name = "Adresse_Fournisseur Resource", description = "L'ensemble des routes pour la partie Adresse_Fournisseur")
public class Adresse_FournisseurRessource {

    @Inject
    EntityManager entityManager;

    @Path("/")
    @GET
    public List<Adresse_Fournisseur> adressesFournisseur_old() {
        return entityManager.createQuery(
            QueryUtils.makeFindAllQuery("Adresse_Fournisseur"))
                .getResultList();
    }

    @Path("/create")
    @POST
    @Transactional
    public Response creerAdresseFournisseur(Adresse_Fournisseur aF) throws Exception {
        entityManager.persist(aF);
        return Response.status(200).build();
    }

    @Path("/modify")
    @PATCH
    @Transactional
    public Adresse_Fournisseur modifAdresseFournisseur(Adresse_Fournisseur aF) throws Exception {
        return entityManager.merge(aF);
    }

    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public Response supprAdresseFournisseur(@PathParam("id") Long id) throws Exception{
        Adresse_Fournisseur aFournisseur = (Adresse_Fournisseur)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Adresse_Fournisseur", "id", id.toString()))
                .getResultList().get(0);
        if (aFournisseur == null) {
            return Response.status(404).build();
        }
        entityManager.remove(aFournisseur);
        return Response.status(200).build();
    }
}