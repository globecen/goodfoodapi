package org.goodfood2.Resource;


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

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.goodfood2.Entity.Users;
import org.goodfood2.Repository.UsersRepository;

import io.quarkus.panache.common.Parameters;
import io.smallrye.jwt.build.Jwt;
import io.smallrye.jwt.build.JwtClaimsBuilder;
@Path("/User")
public class UserResource {

    UsersRepository repository;
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getAllUsers")
    @GET
    public List<Users> users() {
        
        return Users.listAll();
    }
    @Counted(
        name = "LeNombreDeRequete",
        description = "Donne le nombre de requête a la base"
    )
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/id={id}")
    @GET
    public List<Users> userId(@PathParam ("id") Long id) {
        return Users.find("id", id).list();
    }
    @Path("/name={name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @GET
    public List<Users> userName(@PathParam ("name") String name) {
        return Users.find("name", name).list();
    }
    @Path("/email={email}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @GET
    public List<Users> userMail(@PathParam ("email") String email) {
        return Users.find("email", email).list();
    }
    String jwt1 = Jwt.claims("/tokenClaims.json").sign();
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
            return "Vous êtes connecté !"+jwt1;
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