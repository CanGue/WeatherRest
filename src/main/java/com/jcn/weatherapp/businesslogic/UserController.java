package com.jcn.weatherapp.businesslogic;

import java.util.Set;

import com.jcn.weatherapp.model.City;
import com.jcn.weatherapp.model.User;

public class UserController {

	private User currentUser;
	
	public void setUser(User currentUser) {
		
		this.currentUser = currentUser;
		
	}


	public void addToSavedCities(City cityToSave) {
	
		currentUser.getSavedCities().add(cityToSave);
		
	}


	public void removeFromSavedCities(City cityToDelete) {
		
		currentUser.getSavedCities().remove(cityToDelete);
		
	}


	public City getUserDefaultCity(City city) {
		
		return currentUser.getDefaultCity();
	}


	public void setUserDefaultCity(City city) {
		
		currentUser.setDefaultCity(city);
		
	}


	public Set<City> getUsersDefaultCities() {
		
		return this.currentUser.getSavedCities();
	}

}
