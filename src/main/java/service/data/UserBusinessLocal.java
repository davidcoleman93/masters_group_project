package service.data;

import java.util.Collection;

import javax.ejb.Local;

import entities.RoleType;
import entities.User;

@Local
public interface UserBusinessLocal {

	User getUser(String username);

	public void addUser(User user);

	public void removeUser(Integer user_id);

	public void updateUser(User user);

	RoleType getRoleType(Integer role_id);

	boolean checkUsername(String username);

	boolean validateUsername(String username, String password);

	public Collection<?> getUserRole(String username);
}
