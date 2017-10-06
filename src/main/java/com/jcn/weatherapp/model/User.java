package com.jcn.weatherapp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@NamedQueries({
@NamedQuery(name = "Users.findAll", query = "SELECT u FROM User u"),
@NamedQuery(name = "Users.findDefaultCity", query = "SELECT u.placeHolderCityName FROM User u WHERE u.id = :id"),})
@Table(name = "WeatherUser")
public class User implements Serializable {

	public void setId(long id) {
		this.id = id;
	}

	public final static String USER_FINDALL = "Users.findAll";
	public final static String USER_FINDDEFAULTCITY = "Users.findDefaultCity";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private int age;
	private String password;
    private String placeHolderCityName;
	

	@Transient
	private City defaultCity;
	@Transient
	private Set<City> savedCities;

	public User() {

		savedCities = new HashSet<City>();
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

	public Set<City> getSavedCities() {
		return savedCities;
	}

	public void setSavedCities(Set<City> savedCities) {
		this.savedCities = savedCities;
	}

	public City getDefaultCity() {
		return defaultCity;
	}

	public void setDefaultCity(City defaultCity) {
		this.defaultCity = defaultCity;
	}

	public long getId() {
		return id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
	
	public String getPlaceHolderCityName() {
		return placeHolderCityName;
	}

	public void setPlaceHolderCityName(String placeHolderCityName) {
		this.placeHolderCityName = placeHolderCityName;
	}
	

}
