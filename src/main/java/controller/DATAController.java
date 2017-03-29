package controller;

import entities.RoleType;
import entities.User;
import service.data.*;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.Collection;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Path("/data")
public class DATAController {
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

	@EJB
	private DataServiceEJBLocal dataEJB;

	// ALL FAILURE EVENT DATA
	@GET
	@Path("/all_failure_events")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<?> allFailureEvents() {
		return dataEJB.allFailureEvents();
	}

	// USER STORY #4
	// Customer Service: Display EVENT_ID/CAUSE_CODE FOR A SPECIFIC IMSI
	@GET
	@Path("/event_cause_per_imsi/{imsi}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<?> eventCausePerIMSI(@PathParam("imsi") Long imsi) {
		return dataEJB.eventCausePerIMSI(imsi);
	}

	// USER STORY #5
	// As a Customer Service Rep, I want to count, for a given IMSI, the number
	// of failures they have had during a given time period.
	@GET
	@Path("/specific_failure_per_period/{startDate}/{endDate}/{imsi}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object specificFailurePerPeriod(@PathParam("startDate") String startDate,
			@PathParam("endDate") String endDate, @PathParam("imsi") Long imsi) {
		return dataEJB.specificFailurePerPeriod(startDate, endDate, imsi);
	}

	// USER STORY #7
	// Support Engineer: List of all IMSIs with call failures during a given
	// time period
	@GET
	@Path("/imsi_per_period/{startDate}/{endDate}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<?> IMSIPerPeriod(@PathParam("startDate") String startDate, @PathParam("endDate") String endDate) {
		return dataEJB.IMSIPerPeriod(startDate, endDate);
	}

	// User Story #8
	// Support Engineer: Count, for a given model of phone, the number of call
	// failures during a given time period.
	@GET
	@Path("/count_per_phone_model/{startDate}/{endDate}/{phoneModel}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object failureCountPerModel(@PathParam("startDate") String startDate, @PathParam("endDate") String endDate,
			@PathParam("phoneModel") String phoneModel) {
		return dataEJB.failureCountPerModel(startDate, endDate, phoneModel);
	}

	// User story #9
	// Network Management Engineer: Count, for each IMSI, the number of call
	// failures and their total duration during a given time period
	@GET
	@Path("/call_data_per_period/{startDate}/{endDate}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<?> callDataPerPeriod(@PathParam("startDate") String startDate,
			@PathParam("endDate") String endDate) {
		return dataEJB.callDataPerPeriod(startDate, endDate);
	}

	// User Story #10
	// As a Network Management Engineer I want to see, for a given model of
	// phone, all the unique failure Event Id and Cause Code combinations they
	// have exhibited and the number of occurrences.
	/*
	 * @GET
	 * 
	 * @Path("/unique_failures_per_phone_model")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Collection<?>
	 * uniqueFailuresPerModel(String phoneModel){ return
	 * dataEJB.uniqueFailuresPerModel(modelTest); }
	 */
}