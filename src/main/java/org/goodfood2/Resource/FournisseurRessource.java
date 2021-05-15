package org.goodfood2.Resource;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.goodfood2.Entity.Fournisseur;
import org.goodfood2.utils.QueryUtils;

@Path("/Fournisseur")
@Tag(name = "Fournisseur Resource", description = "L'ensemble des routes pour la partie Fournisseur")
public class FournisseurRessource {
  
    @Inject
    EntityManager entityManager;
  
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Fournisseur> adressesUtilisateur() {
        return entityManager.createQuery(
            QueryUtils.makeFindAllQuery("Fournisseur"))
                .getResultList();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    @POST
    @Transactional
    public Response creerFournisseur(Fournisseur f) throws Exception {
        entityManager.persist(f);
        return Response.status(200).build();
    }
}