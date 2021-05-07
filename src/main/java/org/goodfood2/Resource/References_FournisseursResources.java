// /* package org.goodfood2.Resource;

// import java.util.List;

// import javax.transaction.Transactional;
// import javax.ws.rs.Consumes;
// import javax.ws.rs.DELETE;
// import javax.ws.rs.GET;
// import javax.ws.rs.PATCH;
// import javax.ws.rs.POST;
// import javax.ws.rs.Path;
// import javax.ws.rs.PathParam;
// import javax.ws.rs.Produces;
// import javax.ws.rs.core.MediaType;
// import javax.ws.rs.core.Response;
// import javax.ws.rs.core.Response.Status;

// import org.goodfood2.Entity.References_Fournisseurs;

// @Path("Reference_Fournisseur")
// public class References_FournisseursResources {
//     @Produces(MediaType.APPLICATION_JSON)
//     @Consumes(MediaType.APPLICATION_JSON)
//     @Path("/getAllReference_Fournisseur")
//     @GET
//     public List<References_Fournisseurs> reference_Fournisseur() {
//         return References_Fournisseurs.listAll();
//     }
//    /*  @Produces(MediaType.APPLICATION_JSON)
//     @Consumes(MediaType.APPLICATION_JSON)
//     @Path("/id={id}")
//     @GET
//     public List<References_Fournisseurs> Reference_FournisseurId(@PathParam ("id") Long id) {
//         return References_Fournisseurs.find("id", id).list();
//     }
//     @Path("/modifyReference_FournisseurById={id}")
//     @PATCH
//     @Produces(MediaType.APPLICATION_JSON)
//     @Consumes(MediaType.APPLICATION_JSON)
//     @Transactional
//     public void modifyReference_Fournisseur(@PathParam("id") Long id) {
 
//     }
//     @Path("/deleteReference_FournisseurById={id}")
//     @DELETE
//     @Produces(MediaType.APPLICATION_JSON)
//     @Consumes(MediaType.APPLICATION_JSON)
//     @Transactional
//     public void deleteReference_Fournisseur(@PathParam("id") Long id) {
//         References_Fournisseurs.delete("id", id);
//     } */
//     @Path("/addReference_Fournisseur")
//     @POST
//     @Produces(MediaType.APPLICATION_JSON)
//     @Consumes(MediaType.APPLICATION_JSON)
//     @Transactional
//     public Response saveReference_Fournisseur(References_Fournisseurs reference_Fournisseur) {
//         reference_Fournisseur.persist();
//         return Response.status(Status.CREATED).entity(reference_Fournisseur).build();
//     }
// } */