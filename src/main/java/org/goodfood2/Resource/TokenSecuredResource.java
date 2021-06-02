package org.goodfood2.Resource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.JsonWebToken;

/**
 * Classe permettant la verification des fonctionnalitees de la securite.
 */
@Path("/secu")
@RequestScoped
public class TokenSecuredResource {

    // Le token de connexion.
    @Inject
    JsonWebToken jwt; 

    /**
     * Route permettant d afficher les informations du token.
     * @param ctx
     * @return
     */
    @GET()
    @Path("info")
    @Produces(MediaType.TEXT_PLAIN)
    public String info(@Context SecurityContext ctx) {
        return getResponseString(ctx); 
    }

    /**
     * Dechiffre le token.
     * @param ctx Le contexte de securite.
     * @return Les informations du token.
     */
    private String getResponseString(SecurityContext ctx) {
        String name;
        if (ctx.getUserPrincipal() == null) { 
            name = "anonymous";
        } else if (!ctx.getUserPrincipal().getName().equals(jwt.getName())) { 
            throw new InternalServerErrorException("Principal and JsonWebToken names do not match");
        } else {
            name = ctx.getUserPrincipal().getName(); 
        }
        return String.format("hello + %s,"
            + " isHttps: %s,"
            + " authScheme: %s,"
            + " hasJWT: %s",
            name, ctx.isSecure(), ctx.getAuthenticationScheme()); 
    }
}