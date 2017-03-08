package controller;

import entities.*;
import service.data.*;
import service.file.DirectoryWatcher;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Path("/data")
public class DATAController {


    @EJB
    private EventCauseBusinessLocal eventCauseEJB;
    @EJB
    private FailureClassBusinessLocal failureClassEJB;
    @EJB
    private FailureEventBusinessLocal failEventEJB;
    @EJB
    private MarketOperatorBusinessLocal marketOpEJB;
    @EJB
    private UserEventTypeBusinessLocal userEventEJB;


    @GET
    @Path("/fail_events")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Object[]> getAllFailureEvents() {
    	List<Object[]> objsFail = null;

        try{
            objsFail = (List<Object[]>)failEventEJB.getAllFailureEvents();
        }catch (Exception e){
            System.out.println("ERROR");
        }

        return objsFail;
    }

    @GET
    @Path("/event_causes")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<EventCause> getAllEventCauses(){
        return (List<EventCause>)eventCauseEJB.getAllEventCauses();
    }

    @GET
    @Path("/failure_classes")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<FailureClass> getAllFailureClasses(){
        return (List<FailureClass>)failureClassEJB.getAllFailureClasses();
    }

    @GET
    @Path("/market_ops")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<MarketOperator> getAllMarketOperators(){
        return (List<MarketOperator>)marketOpEJB.getAllMarketOperators();
    }

    @GET
    @Path("/user_events")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<UserEventType> getAllUserEventTypes(){
        return (List<UserEventType>)userEventEJB.getAllUserEventTypes();
    }

}