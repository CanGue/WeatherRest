package com.jcn.weatherapp.businesslogic;

import java.io.IOException;
import java.util.Optional;

import javax.ejb.Stateless;

import org.json.JSONException;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;

/**
 * Session Bean implementation class CurrentWeatherData
 */
@Stateless
public class CurrentWeatherData {

	private OpenWeatherMap openWeatherMap;
	
	public CurrentWeatherData() {

	}
	
	public CurrentWeatherData(OpenWeatherMap openWeatherMap){
		
		this.openWeatherMap = openWeatherMap;
	}

	public Optional<CurrentWeather> getCurrentWeatherForCity(String citryName) {

		if(openWeatherMap == null){
		openWeatherMap = new OpenWeatherMap("cfa0303b629db64fb6d292d17f76f44d");
		}
		
		Optional<CurrentWeather> currentWeather;
		try {
			currentWeather = Optional.ofNullable(openWeatherMap.currentWeatherByCityName(citryName));
		} catch (JSONException | IOException e) {
			currentWeather = Optional.ofNullable(null);
			e.printStackTrace();
		}
		return currentWeather;

	}

}
