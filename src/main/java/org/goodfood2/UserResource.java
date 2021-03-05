package org.goodfood2;


import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.quarkus.panache.common.Parameters;
@Path("/account")
public class UserResource {
    @Path("/getAllUsers")
    @GET
    public List<Users> users() {
        
        return Users.listAll();
    }
    @Path("/getOneUser/{id}")
    @POST
    public List<Users> user(@PathParam ("id") Long id) {
        return Users.find("id", id).list();
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
            return "Vous êtes connecter !";
        }
    }
    @Path("/addUser")
    @POST
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