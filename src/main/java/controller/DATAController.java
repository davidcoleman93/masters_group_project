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
        CODE REFACTOR NEEDED!!
        'USERController' to be created to reduce coupling/reusability of code
     */

    @EJB
    private UserBusinessLocal userEJB;

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getAllUsers() {
        return userEJB.getAllUsers();
    }

    @GET
    @Path("/users/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean checkUsername(@PathParam("username") String username) {
        return userEJB.checkUsername(username);
    }

    @GET
    @Path("/roletype/{roleTypeID}")
    @Produces(MediaType.APPLICATION_JSON)
    public RoleType getRoleType(@PathParam("roleTypeID") Integer roleTypeID) {
        return userEJB.getRoleType(roleTypeID);
    }

    @Path("/adduser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(User user) {
        userEJB.addUser(user);
    }

    @Path("/login/{username}/{password}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public boolean login(@PathParam("username") String username, @PathParam("password") String password) {
        return userEJB.validateUsername(username, password);
    }

    @Path("/{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("username") String username) {
        return userEJB.getUser(username);
    }

    @Path("/{user_id}")
    @DELETE
    public void removeUser(@PathParam("user_id") Integer user_id) {
        userEJB.removeUser(user_id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User user) {
        userEJB.updateUser(user);
    }

    /*
        DATA REST CONTROLLER
     */

    @EJB
    private DataServiceEJBLocal dataEJB;

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
    @Path("/all_unique_imsis/{imsi}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getAllUniqueIMSIsV2(@PathParam("imsi") Long imsi)
    {
    	return dataEJB.getAllUniqueIMSIsV2(imsi);
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
    @Path("/event_cause/by_ue_type/{ueType}")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<?> getFailEventAndCauseCodeByUEType(@PathParam("ueType") Integer ueType){
        return dataEJB.getFailEventAndCauseCodeByUEType(ueType);
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