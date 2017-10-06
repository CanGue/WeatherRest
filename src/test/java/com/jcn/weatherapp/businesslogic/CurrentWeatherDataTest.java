package com.jcn.weatherapp.businesslogic;

import static junitparams.JUnitParamsRunner.$;

import java.io.IOException;
import java.util.Optional;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;

@RunWith(JUnitParamsRunner.class)
public class CurrentWeatherDataTest {

	
	private static final int STATUS_OK = 200;
	private static final Object[] getExampleCitys(){    
		return $(      
		$("Ansbach"),      
		$("London"),
		$("Barcelona"),
		$("New York")
		);
		}

	
	private CurrentWeatherData currentWeatherData = new CurrentWeatherData();
	
	
	OpenWeatherMap openWeaterMap = Mockito.mock(OpenWeatherMap.class);
	
	
	@Test
	@Parameters(method = "getExampleCitys")
	public void getCurrentWeatherForCityShouldReturnStatusOK(String city) {
		
		//GIVEN instance of currenWeatherData
		
		//WHEN
		Optional<CurrentWeather> currentWeatherForCity = currentWeatherData.getCurrentWeatherForCity(city);
		
		//THEN
		Assert.assertEquals(STATUS_OK, currentWeatherForCity.get().getResponseCode());

	}
	
	@Test
	public void getCurrentWeatherShouldInvokeCurrentWeatherByCity() throws JSONException, IOException{
		
		//GIVEN
		currentWeatherData = new CurrentWeatherData(openWeaterMap);		
		//WHEN		
		currentWeatherData.getCurrentWeatherForCity(Mockito.anyString());
		
		//THEN		
		Mockito.verify(openWeaterMap).currentWeatherByCityName(Mockito.anyString());
	}
	


}
