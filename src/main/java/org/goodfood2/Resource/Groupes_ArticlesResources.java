// package org.goodfood2.Resource;

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

// import org.goodfood2.Entity.Groupes_Articles;

// @Path("/Groupe_Article")

// public class Groupes_ArticlesResources {
//     @Produces(MediaType.APPLICATION_JSON)
//     @Consumes(MediaType.APPLICATION_JSON)
//     @Path("/getAllGroupe_Article")
//     @GET
//     public List<Groupes_Articles> groupe_Article() {
//         return Groupes_Articles.listAll();
//     }
//    /*  @Produces(MediaType.APPLICATION_JSON)
//     @Consumes(MediaType.APPLICATION_JSON)
//     @Path("/id={id}")
//     @GET
//     public List<Groupes_Articles> groupe_ArticleId(@PathParam ("id") Long id) {
//         return Groupes_Articles.find("id", id).list();
//     }
//     @Path("/modifyFounisseurById={id}")
//     @PATCH
//     @Produces(MediaType.APPLICATION_JSON)
//     @Consumes(MediaType.APPLICATION_JSON)
//     @Transactional
//     public void modifyGroupe_Article(@PathParam("id") Long id) {
 
//     }
//     @Path("/deleteFournisseurById={id}")
//     @DELETE
//     @Produces(MediaType.APPLICATION_JSON)
//     @Consumes(MediaType.APPLICATION_JSON)
//     @Transactional
//     public void deleteGroupe_Article(@PathParam("id") Long id) {
//         Groupes_Articles.delete("id", id);
//     } */
//     @Path("/addGroupeArticle")
//     @POST
//     @Produces(MediaType.APPLICATION_JSON)
//     @Consumes(MediaType.APPLICATION_JSON)
//     @Transactional
//     public Response saveGroupe_Article(Groupes_Articles groupe_Article) {
//         groupe_Article.persist();
//         return Response.status(Status.CREATED).entity(groupe_Article).build();
//     }
// }
