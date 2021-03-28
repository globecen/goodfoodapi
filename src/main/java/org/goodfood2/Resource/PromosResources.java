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

import org.goodfood2.Entity.Promos;

@Path("/Promo")
public class PromosResources {
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getAllPromos")
    @GET
    public List<Promos> promos() {
        return Promos.listAll();
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/id={id}")
    @GET
    public List<Promos> promoId(@PathParam ("id") Long id) {
        return Promos.find("id", id).list();
    }
    @Path("/modifyPromoById={id}")
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void modifyPromo(@PathParam("id") Long id) {
 
    }
    @Path("/deletePromoById={id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public void deletePromo(@PathParam("id") Long id) {
        Promos.delete("id", id);
    }
    @Path("/addPromo")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response savePromo(Promos promo) {
        promo.persist();
        return Response.status(Status.CREATED).entity(promo).build();
    }
}
