package org.goodfood2;


import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.metrics.annotation.Counted;

import io.quarkus.panache.common.Parameters;
@Path("/account")
public class UserResource {


    @Inject
    UsersRepository repository;

    @Path("/getAllUsers")
    @GET
    public List<Users> users() {
        
        return Users.listAll();
    }
    @Counted(
        name = "LeNombreDeRequete",
        description = "Donne le nombre de requête a la base"
    )
    @Path("/getOneUser/{id}")
    @POST
    public List<Users> userId(@PathParam ("id") Long id) {
        return Users.find("id", id).list();
    }
    @Path("/getOneUser/{name}")
    @POST
    public List<Users> userName(@PathParam ("name") String name) {
        return repository.findByName(name);
    }
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/login/{email}&{password}")
    @POST
    public String val (@PathParam ("email")String email,  @PathParam ("password")String password) {
        Long nb =Users.find("email =:email and password = :password", Parameters.with("email", email).and("password", password)).count();
        if (nb==0)
        {
            return "Email ou mot de passe incorrect !"; 
        }
        else {
            return "Vous êtes connecté !";
        }
    }
    //
    @Path("/addUser")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveUser(Users user){
        user.persist();
        return Response.status(Status.CREATED).entity(user).build();
    }
    
   /* @Path("/fr")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String bonjour() {
        return "Bonjour RESTEasy";
    }
    */
}