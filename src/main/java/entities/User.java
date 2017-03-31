package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by D15123999 on 19/03/2017.
 */

@Entity
@Table(name = "users")
public class User implements Serializable {	
	//private static final long serialVersionUID = 5409018160475255408L;

	//Define the users table rows
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	
	//@NotNull
	@Column(name = "username", unique = true)
	//@Size(max = 45)
	private String username;

	@Column(name = "email")
	//@Size(max = 45)
	private String email;
	
	//@NotNull
	@Column(name = "password")
	private String password;

	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	@ManyToOne
	private RoleType roleType;
	
	public User (){}
		
	public User(String username, String email, String password, RoleType roleType){

	this.username = username;
	this.email = email;
	this.password = password;
	this.roleType = roleType;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}


	
}













