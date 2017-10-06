package com.jcn.weatherapp.businesslogic;

import static junitparams.JUnitParamsRunner.$;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import com.jcn.weatherapp.model.City;
import com.jcn.weatherapp.model.User;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class UserControllerTest {

	City cityAnsbach = new City("Ansbach");
	City cityNewYork = new City("New York");
	User user = new User();
	UserController userController = new UserController();

	private static final Object[] getExampleCitys() {
		return $($("Ansbach"), $("London"), $("Barcelona"), $("New York"));
	}

	@Test
	public void saveToFavouriteCitiesShouldAddOneCitiesToTheList() {
		// Given
		// Cities and UserController
		// WHEN
		userController.setUser(user);
		userController.addToSavedCities(cityAnsbach);
		userController.addToSavedCities(cityNewYork);
		// THEN
		Assert.assertEquals(2, user.getSavedCities().size());

	}

	@Test
	public void deleteFromFavouriteCitiesShouldRemoveSavedCities() {

		// Given Cities and UserController
		// WHEN
		userController.setUser(user);
		userController.addToSavedCities(cityAnsbach);
		userController.addToSavedCities(cityNewYork);
		userController.removeFromSavedCities(cityAnsbach);

		// THEN
		Assert.assertEquals(1, user.getSavedCities().size());

	}

	@Test
	@Parameters(method = "getExampleCitys")
	public void thereShouldBeNoDuplicateCitiesInTheSavedCitiesList(String cityName) {

		// GIVEN
		City duplicateCity = new City(cityName);
		userController.setUser(user);
		// WHEN
		userController.addToSavedCities(duplicateCity);
		userController.addToSavedCities(duplicateCity);
		// THEN
		Assert.assertEquals(userController.getUsersDefaultCities().size(), 1);

	}

	@Test
	public void deletedSavedCitiesElementShouldNotBeInTheListAnymore() {

		// Given Cities and UserController
		// WHEN
		userController.setUser(user);
		userController.addToSavedCities(cityAnsbach);
		userController.addToSavedCities(cityNewYork);
		// THEN
		Assert.assertTrue(user.getSavedCities().contains(cityAnsbach));
		// ALSO WHEN
		userController.removeFromSavedCities(cityAnsbach);
		// THEN
		Assert.assertFalse(user.getSavedCities().contains(cityAnsbach));

	}

	@Test
	@Parameters(method = "getExampleCitys")
	public void userCanSetADefaultCity(String defaultCity) {

		// GIVEN
		City city = new City(defaultCity);
		userController.setUser(user);
		// WHEN
		userController.setUserDefaultCity(city);
		// THEN
		Assert.assertEquals(city, userController.getUserDefaultCity(city));

	}

}
