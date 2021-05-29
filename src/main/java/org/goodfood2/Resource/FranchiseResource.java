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
import org.goodfood2.Entity.Franchise;
import org.goodfood2.utils.QueryUtils;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

@Path("/Franchise")
@Tag(name = "Franchise Resource", description = "L'ensemble des routes pour la partie Franchise")
public class FranchiseResource {
    
    @Inject
    EntityManager entityManager;

    @Path("/")
    @GET
    @PermitAll
    public List<Franchise> franchises(@DefaultValue("") @QueryParam("search") String search) {
        // select emailFranchise, idFranchise, idGroupeFranchise, nomFranchise, numeroSiretFranchise, numeroTelFranchise
        if(search.isEmpty()){
            return entityManager.createQuery("from Franchise").getResultList();
        }else{
            String emailFranchise, idFranchise, idGroupeFranchise, nomFranchise, numeroSiretFranchise, numeroTelFranchise;
            emailFranchise = "emailFranchise like '" + search + "' OR ";
            idFranchise = "idFranchise like '" + search + "' OR ";
            idGroupeFranchise = "idGroupeFranchise like '" + search + "' OR ";
            nomFranchise = "nomFranchise like '%" + search + "%' OR ";
            numeroSiretFranchise = "numeroSiretFranchise like '" + search + "' OR ";
            numeroTelFranchise = "numeroTelFranchise like '" + search + "'";
            // System.out.println("from Franchise  where " + emailFranchise + idFranchise + idGroupeFranchise + nomFranchise + numeroSiretFranchise + numeroTelFranchise);
            return entityManager.createQuery("from Franchise  where " + emailFranchise + idFranchise + idGroupeFranchise + nomFranchise + numeroSiretFranchise + numeroTelFranchise).getResultList();
    
        }
    }

    @Path("/create")
    @POST
    @Transactional
    public Response creerFranchise(Franchise f) throws Exception {
        entityManager.persist(f);
        return Response.status(200).build();
    }


    @Path("/modify")
    @PATCH
    @Transactional
    public Franchise modifFranchise(Franchise f) throws Exception {
        return entityManager.merge(f);
    }


    @Path("/delete/{id}")
    @DELETE
    @Transactional
    public Response supprFranchise(@PathParam("id") Long id) throws Exception{
        Franchise f = (Franchise)entityManager.createQuery(
            QueryUtils.makeFindByParamQueryInt("Franchise", "id", id.toString()))
                .getResultList().get(0);
        if (f == null) {
            return Response.status(404).build();
        }
        entityManager.remove(f);
        return Response.status(200).build();
    }
}
