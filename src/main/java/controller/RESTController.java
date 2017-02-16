package controller;

import business.TestBusinessLocal;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Path("/test")
public class RESTController {

    @EJB
    private TestBusinessLocal ejb;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getAll() {
        return ejb.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addRecord(Object o){
        ejb.addRecord(o);
    }

}