package controller;

import service.data.*;

import javax.ejb.EJB;
import javax.persistence.Access;
import javax.persistence.criteria.CriteriaBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Path("/data")
public class DATAController {

    @EJB
    private FailureEventBusinessLocal failEventEJB;
    @EJB
    private DataServiceEJBLocal dataEJB;

    //ALL FAILURE EVENT DATA
    @GET
    @Path("/all_failure_events")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> allFailureEvents(){
        return dataEJB.allFailureEvents();
    }

    //USER STORY #4
    //Customer Service: Display EVENT_ID/CAUSE_CODE FOR A SPECIFIC IMSI
    @GET
    @Path("/event_cause_per_imsi/{imsi}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<?> eventCausePerIMSI(@PathParam("imsi") Long imsi) {
        System.out.println(imsi);
        return dataEJB.eventCausePerIMSI(imsi);
    }

    //USER STORY #5
    //As a Customer Service Rep, I want to count, for a given IMSI, the number of failures they have had during a given time period.
    @GET
    @Path("/specific_failure_per_period/{startDate}/{endDate}/{imsi}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object specificFailurePerPeriod(@PathParam("startDate") String startDate, @PathParam("endDate") String endDate, @PathParam("imsi") Long imsi) {
        System.out.println(startDate + ":" + endDate);
        return dataEJB.specificFailurePerPeriod(startDate, endDate, imsi);
    }

    //USER STORY #7
    //Support Engineer: List of all IMSIs with call failures during a given time period
    @GET
    @Path("/imsi_per_period/{startDate}/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> IMSIPerPeriod(@PathParam("startDate") String startDate, @PathParam("endDate") String endDate) {
        return dataEJB.IMSIPerPeriod(startDate, endDate);
    }

    //User Story #8
    //Support Engineer: Count, for a given model of phone, the number of call failures during a given time period.
    @GET
    @Path("/count_per_phone_model/{startDate}/{endDate}/{phoneModel}")
    @Produces(MediaType.APPLICATION_JSON)
    public Object failureCountPerModel(@PathParam("startDate") String startDate, @PathParam("endDate") String endDate, @PathParam("phoneModel") String phoneModel) {
        return dataEJB.failureCountPerModel(startDate, endDate, phoneModel);
    }

    //User story #9
    //Network Management Engineer: Count, for each IMSI, the number of call failures and their total duration during a given time period
    @GET
    @Path("/call_data_per_period/{startDate}/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> callDataPerPeriod(@PathParam("startDate") String startDate, @PathParam("endDate") String endDate) {
        return dataEJB.callDataPerPeriod(startDate, endDate);
    }

    //User Story #10
    //As a Network Management Engineer I want to see, for a given model of phone, all the unique failure Event Id and Cause Code combinations they have exhibited and the number of occurrences.
    /*@GET
    @Path("/unique_failures_per_phone_model")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> uniqueFailuresPerModel(String phoneModel){
        return dataEJB.uniqueFailuresPerModel(modelTest);
    }*/
}