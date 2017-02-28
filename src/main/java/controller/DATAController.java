package controller;

import entities.FailureClass;
import service.DataServiceLocal;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by C06590861 on 23/02/2017.
 */

@Path("/data")
public class DATAController {

    @EJB
    private DataServiceLocal dataEJB;

    @POST
    @Path("/upload_data")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addGoodData(){
        dataEJB.addData();
    }

    @GET
    @Path("/call_failures")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getCallFailures(){
        return dataEJB.getCallFailures();
    }

}
