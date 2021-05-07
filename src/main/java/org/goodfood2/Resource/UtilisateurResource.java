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
import org.eclipse.microprofile.metrics.annotation.Counted;
import io.quarkus.panache.common.Parameters;
import org.goodfood2.utils.TokenUtils;
import io.quarkus.elytron.security.common.BcryptUtil;
import org.goodfood2.Entity.*;

@Path("/Utilisateur")
public class UtilisateurResource {
    //@Inject
    //UsersRepository repository;

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    @GET
    public List<Utilisateur> utilisateur() {
        return Utilisateur.listAll();
    }
   /*  @Counted(
        name = "LeNombreDeRequete",
        description = "Donne le nombre de requête a la base"
    )


    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id={id}")
    @GET
    public List<Users> userId(@PathParam ("id") Long id) {
        return Users.find("id", id).list();
    }

    @Path("/name={name}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Users> userName(@PathParam ("name") String name) {
        return Users.find("name", name).list();
    }

    @Path("/email={email}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Users> userEmail(@PathParam ("email") String email) {
        return Users.find("email", email).list();
    }

    @Produces(MediaType.TEXT_PLAIN)
    @Path("/login/email={email}&password={password}")
    @POST
    public String val (@PathParam ("email")String email,  @PathParam ("password")String password) throws Exception {
        long tokenDuration = 3600;
        //String issuer = "https://localhost:8080/issuer";
        
        Long nb =Users.find("email =:email and password = :password", Parameters.with("email", email).and("password", BcryptUtil.bcryptHash(password))).count();
        if (nb==0)
        {
            return "Email ou mot de passe incorrect !"; 
        }
        else {
            Users users = Users.find("email =:email and password = :password", Parameters.with("email", email).and("password", password)).firstResult();
            long id = users.id;
            String role = users.role;
            String token = TokenUtils.generateToken(tokenDuration, email,id,role);
            return token;
        }
    }

    // */
    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public String addUtilisateur(Utilisateur utilisateur){
        
        // if (Utilisateur.find("email =:email", Parameters.with("email", Utilisateur.getEmail())).count()>0)
        // {
        // return "email déjà existante";
        // }
        // else {
            utilisateur.persist();
        // }
        return "création de compte ok";
    }
    /* @Path("/fr")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String bonjour() {
        return "Bonjour RESTEasy";
    }
    */
}