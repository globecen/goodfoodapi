package org.goodfood2.Resource;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.inject.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.goodfood2.Entity.Log;
import javax.transaction.Transactional;

@Path("log")
public class LogResources {
    @Consumes(MediaType.APPLICATION_JSON)
    @GET
    @Path("/")
    @RolesAllowed({ "admin" })
    public List<Log> log(){
        return Log.listAll();
    }
    
}
