package com.jcn.weatherapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
@NamedQuery(name = "Users.findAll", query = "SELECT u FROM User u")})
@Table(name = "USER_WEATHERAPP")
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	public final static String USER_FINDALL = "Users.findAll";
	public final static String USER_FINDDEFAULTCITY = "Users.findDefaultCity";

	@Id
	private long id;
	private String firstName;
	private String lastName;
	private int age;
	private String cityName;

	public User() {
	
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public long getId() {
		return id;
	}

	
	

}
