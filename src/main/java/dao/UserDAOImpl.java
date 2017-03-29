package dao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.RoleType;
import entities.User;

import java.util.Collection;
import java.util.List;

@Local
@Stateless
public class UserDAOImpl implements UserDAOLocal {

	@PersistenceContext
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<?> getAllUsers() {
		return (List<User>) em.createQuery("FROM User ").getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public User getUser(String username) {
		return (User) em.createQuery("SELECT o FROM User o WHERE o.username=:username")
				.setParameter("username", username).getSingleResult();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addUser(User user) {
		em.persist(user);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeUser(Integer user_id) {
		User user = (User) em.createQuery("SELECT o FROM User o WHERE o.user_id=:user_id")
				.setParameter("user_id", user_id).getSingleResult();
		em.remove(user_id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateUser(User user) {
		em.merge(user);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public RoleType getRoleType(Integer role_id) {
		return (RoleType) em.createQuery("SELECT o FROM RoleType o WHERE o.role_id=:role_id")
				.setParameter("role_id", role_id).getSingleResult();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean checkUsername(String username) {
		return em.createQuery("SELECT u FROM User u WHERE u.username=:username").setParameter("username", username)
				.setMaxResults(1).getResultList().isEmpty();
	}

	public boolean validateUsername(String username, String password) {
		return em.createQuery("SELECT o FROM User o WHERE o.username=:username AND o.password=:password").
				setParameter("username", username)
				.setParameter("password", password)
				.setMaxResults(1).getResultList().isEmpty();
		}

	/*
	 * public boolean checkUser(String username){ //RETURN TRUE IF NOT FOUND
	 * return em.
	 * createQuery("SELECT o FROM User o WHERE o.username=:username AND o.password=:password"
	 * ) .setParameter("username", username) .setParameter("password", password)
	 * .setMaxResults(1) .getResultList() .isEmpty(); }
	 */
}