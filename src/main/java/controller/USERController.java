package controller;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.RoleType;
import entities.User;
import service.data.UserBusinessLocal;

/**
 * Created by C06590861 on 15/02/2017.
 */

@Path("/data")
public class USERController {

	/*
	 * CODE REFACTOR NEEDED!! 'USERController' to be created to reduce
	 * coupling/reusability of code
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
	@Path("/users/role/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<?> getUserRole(@PathParam("username") String username) {
		return userEJB.getUserRole(username);
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

}
