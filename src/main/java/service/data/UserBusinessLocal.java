package service.data;

import entities.RoleType;
import entities.User;

import java.util.Collection;

import javax.ejb.Local;

@Local
public interface UserBusinessLocal {

	Collection<?> getAllUsers();
	User getUser(String username);
	public void addUser(User user);
	public void removeUser(Integer user_id);
	public void updateUser(User user);
	RoleType getRoleType(Integer role_id);
	boolean checkUsername(String username);
	 boolean validateUsername(String username, String password);
}
