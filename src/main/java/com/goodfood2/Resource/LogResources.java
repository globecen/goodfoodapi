package com.goodfood2.Resource;

import java.util.List;

import com.goodfood2.Entity.Log;

import jakarta.annotation.security.RolesAllowed;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("log")
public class LogResources {
    @Consumes(MediaType.APPLICATION_JSON)
    @GET
    @Path("/")
    @RolesAllowed({ "admin" })
    public List<Log> log() {
        return Log.listAll();
    }

}
