package controller;

import business.TestBusinessLocal;
import entities.test_entities.TableUn;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Path("/test")
public class RESTController {

    @EJB
    private TestBusinessLocal ejb;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TableUn> getAll(){
        return ejb.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addRecord(){
        ejb.addRecord();
    }

}
