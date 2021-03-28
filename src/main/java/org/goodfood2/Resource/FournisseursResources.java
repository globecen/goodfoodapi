package org.goodfood2.Resource;

import java.util.List;

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
import javax.ws.rs.core.Response.Status;

import org.goodfood2.Entity.Fournisseurs;
import org.goodfood2.Entity.Promos;

@Path("/Fournisseur")
public class FournisseursResources {
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getAllFournisseur")
    @GET
    public List<Fournisseurs> promos() {
        return Fournisseurs.listAll();
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/id={id}")
    @GET
    public List<Promos> fournisseurId(@PathParam ("id") Long id) {
        return Promos.find("id", id).list();
    }
    @Path("/modifyFounisseurById={id}")
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void modifyPromo(@PathParam("id") Long id) {
 
    }
    @Path("/deleteFournisseurById={id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void deleteFournisseur(@PathParam("id") Long id) {
        Promos.delete("id", id);
    }
    @Path("/addFournisseur")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveFournisseur(Fournisseurs fournisseur) {
        fournisseur.persist();
        return Response.status(Status.CREATED).entity(fournisseur).build();
    }
}
