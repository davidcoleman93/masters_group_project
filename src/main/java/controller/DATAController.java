package controller;

import service.data.*;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.Collection;
import java.util.Date;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Path("/data")
public class DATAController {

    @EJB
    private FailureEventBusinessLocal failEventEJB;

    //USER STORY #4
    //Customer Service: Display EVENT_ID/CAUSE_CODE FOR A SPECIFIC IMSI
    @GET
    @Path("/event_cause/{imsi}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getEventCausePerIMSI(@PathParam("imsi") Long imsi){
        return failEventEJB.getEventCausePerIMSI(imsi);
    }
}