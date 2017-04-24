package dao;

import java.util.Collection;

import javax.ejb.Local;

import entities.RoleType;
import entities.User;

@Local
public interface UserDAOLocal {

	User getUser(String username);

	void addUser(User user);

	void removeUser(Integer user_id);

	void updateUser(User user);

	RoleType getRoleType(Integer role_id);

	boolean checkUsername(String username);

	boolean validateUsername(String username, String password);

	public Collection<?> getUserRole(String username);
	// boolean checkUser(String username, String password);
}
