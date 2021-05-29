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
import org.goodfood2.Entity.Allergene;
import org.goodfood2.utils.QueryUtils;

@Path("/Allergene")
@Tag(name = "Allergene Resource", description = "L'ensemble des routes pour la partie Allergene")
public class AllergeneRessource {

    @Inject
    EntityManager entityManager;

    @Path("/")
    @GET
    public List<Allergene> allergenes() {
        return entityManager.createQuery(
            QueryUtils.makeFindAllQuery("Allergene"))
                .getResultList();
    }

    @Path("/create")
    @POST
    @Transactional
    public Response creerAllergene(Allergene a) throws Exception {
        entityManager.persist(a);
        return Response.status(200).build();
    }

    @Path("/modify")
    @PATCH
    @Transactional
    public Allergene modifAllergene(Allergene a) throws Exception {
        return entityManager.merge(a);
    }

    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public Response supprAdresseUtilisateur(@PathParam("id") Long id) throws Exception{
        Allergene a = (Allergene)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Allergene", "id", id.toString()))
                .getResultList().get(0);
        if (a == null) {
            return Response.status(404).build();
        }
        entityManager.remove(a);
        return Response.status(200).build();
    }
}