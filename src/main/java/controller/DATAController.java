package controller;

import entities.RoleType;
import entities.User;
import service.data.*;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Path("/data")
public class DATAController {
    /*
        DATA REST CONTROLLER
     */
    @EJB
    private DataServiceEJBLocal dataEJB;
    @EJB
    private EventCauseValidationEJBLocal eventCauseEJB;
    @EJB
    private MarketOperatorValidationEJBLocal marketOperatorEJB;
    @EJB
    private UserEventValidationEJBLocal userEventEJB;
    @EJB
    private FailureClassBusinessLocal failureClassEJB;

    //ALL FAILURE EVENT DATA
    @GET
    @Path("/all_failure_events")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> allFailureEvents(){
        return dataEJB.allFailureEvents();
    }

    //ALL DATA IMPORT LOGS
    @GET
    @Path("/data_import_logs")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> dataImportLog(){
        return dataEJB.dataImportLogs();
    }
    
    @GET
    @Path("/all_unique_phone_models")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getAllUniquePhoneModels()
    {
    	return dataEJB.getAllUniquePhoneModels();
    }

    @GET
    @Path("/all_unique_ue_types")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getAllUniqueUETypes()
    {
        return dataEJB.getAllUniqueUETypes();
    }
    
    @GET
    @Path("/all_unique_imsis")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getAllUniqueIMSIs()
    {
    	return dataEJB.getAllUniqueIMSIs();
    }

    @GET
    @Path("/all_unique_failure_class")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getAllUniqueFailureClasses()
    {
        return dataEJB.getAllUniqueFailureClasses();
    }
    
    @GET
    @Path("/all_unique_imsis/{imsi}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getAllUniqueIMSIsV2(@PathParam("imsi") Long imsi)
    {
    	return dataEJB.getAllUniqueIMSIsV2(imsi);
    }

    /*
        LOOKUP TABLES
     */
    @GET
    @Path("/event_causes")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> allEventCauses(){
        return eventCauseEJB.allEventCauses();
    }

    @GET
    @Path("/market_operators")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> allMarketOperators(){
        return marketOperatorEJB.allMarketOperators();
    }

    @GET
    @Path("/user_event_types")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> allUserEventTypes(){
        return userEventEJB.allUserEventTypes();
    }

    @GET
    @Path("/failure_classes")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> allFailureClasses(){
        return failureClassEJB.allFailureClasses();
    }

    //USER STORY #4
    //Customer Service: Display EVENT_ID/CAUSE_CODE FOR A SPECIFIC IMSI
    @GET
    @Path("/event_cause_per_imsi/{imsi}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Collection<?> eventCausePerIMSI(@PathParam("imsi") Long imsi) {
        return dataEJB.eventCausePerIMSI(imsi);
    }

    //USER STORY #5
    //As a Customer Service Rep, I want to count, for a given IMSI, the number of failures they have had during a given time period.
    @GET
    @Path("/specific_failure_per_period/{startDate}/{endDate}/{imsi}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Object specificFailurePerPeriod(@PathParam("startDate") String startDate, @PathParam("endDate") String endDate, @PathParam("imsi") Long imsi) {
        return dataEJB.specificFailurePerPeriod(startDate, endDate, imsi);
    }

    //USER STORY #6
    //Customer Service: Display unique CAUSE_CODEs for a specific imsi
    //and the number of occurances.
    @GET
    @Path("/event_cause/by_imsi/{imsi}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getFailEventsUsingImsiGroupedByCauseCode(@PathParam("imsi") Long imsi){
        return dataEJB.getFailEventsUsingImsiGroupedByCauseCode(imsi);
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

    //USER STORY #10
    //Network Mgt Engineer: Display unique EVENT_ID/CAUSE_CODE combinations for a specific ueType
    // and the number of occurances.
    @GET
    @Path("/event_cause/by_ue_type/{model}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getFailEventAndCauseCodeByUEType(@PathParam("model") String model){
        return dataEJB.getFailEventAndCauseCodeByUEType(model);
    }

    //User story #11
    //Network Management Engineer: Count, for each IMSI, the number of call failures and their total duration during a given time period
    @GET
    @Path("/top_ten_per_period/{startDate}/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> topTenCallFailurePerPeriod(@PathParam("startDate") String startDate, @PathParam("endDate") String endDate) {
        return dataEJB.topTenCallFailurePerPeriod(startDate, endDate);
    }

    //User Story #12
    //Network Mgt Engineer: Display Top 10 IMSIs that had call failures during a time period
    @GET
    @Path("/call_data_per_period/top_ten/{startDate}/{endDate}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getTopTenIMSIsForFailureClassPerPeriod(@PathParam("startDate") String startDate, @PathParam("endDate") String endDate) {
        return dataEJB.getTopTenIMSIsForFailureClassPerPeriod(startDate, endDate);
    }

    //User Story #13
    @GET
    @Path("/top_ten_node")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getTopTenNodeFailuresPercentage(){
        return dataEJB.getTopTenNodeFailuresPercentage();
    }

    //USER STORY #14
    //Network Mgt Engineer: Display unique EVENT_ID/CAUSE_CODE combinations for a specific ueType
    // and the number of occurances.
    @GET
    @Path("/failure_class/get_imsis/{failureClass}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getIMSisForFailureClass(@PathParam("failureClass") Integer failureClass){
        return dataEJB.getIMSisForFailureClass(failureClass);
    }
}