package service.data;

import java.util.Collection;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.UserDAOLocal;
import entities.RoleType;
import entities.User;

@Local
@Stateless
public class UserBusinessImpl implements UserBusinessLocal {

	@Inject
	private UserDAOLocal daoBean;

	@Resource
	private SessionContext session;

	public void addUser(User user) {
		daoBean.addUser(user);
	}

	/*
	 * public boolean checkUser(String username, String password){ return
	 * daoBean.checkUser(username, password); }
	 */

	public User getUser(String username) {
		return daoBean.getUser(username);
	}

	public void removeUser(Integer user_id) {
		daoBean.removeUser(user_id);
	}

	public RoleType getRoleType(Integer role_id) {
		return daoBean.getRoleType(role_id);
	}

	public void updateUser(User user) {
		daoBean.updateUser(user);
	}

	public boolean checkUsername(String username) {
		return daoBean.checkUsername(username);
	}

	public boolean validateUsername(String username, String password) {
		return daoBean.validateUsername(username, password);
	}

	public Collection<?> getUserRole(String username) {
		return daoBean.getUserRole(username);
	}

}// UserBusinessImpl
