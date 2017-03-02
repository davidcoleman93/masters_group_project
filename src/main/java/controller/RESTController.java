package controller;

import entities.*;
import service.*;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.Collection;
import java.util.List;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Path("/main")
public class RESTController {

    //private final String DIR_NAME = "Files";

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

    @POST
    @Path("/import")
    public void importFile(){

        //new FileChecker();
    }
    
	@POST
	@Path("/csv")
	public void postCSV() {
		failEventEJB.postCSV();
	}
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addFaiLEvent(FailureEvent fEvent) {
		failEventEJB.addFailEvent(fEvent);
	}

    @GET
    @Path("/fail_events")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<FailureEvent> getAllFailureEvents() {
        return (List<FailureEvent>)failEventEJB.getAllFailureEvents();
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