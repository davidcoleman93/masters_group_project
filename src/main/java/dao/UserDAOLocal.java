package dao;

import javax.ejb.Local;

import entities.RoleType;
import entities.User;
import java.util.Collection;

@Local
public interface UserDAOLocal {

	Collection<?> getAllUsers();
    User getUser(String username);
    void addUser(User user);
    void removeUser(Integer user_id);
    void updateUser(User user);
    RoleType getRoleType(Integer role_id);
    boolean checkUsername(String username);
    boolean validateUsername(String username, String password);
    
    //boolean checkUser(String username, String password);
}
