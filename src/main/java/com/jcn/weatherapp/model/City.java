package com.jcn.weatherapp.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City implements Serializable {

	
	private String cityName;
	@Id
	private Coordinate coordintes;

	public City(String defaultCityName) {
		
		this.cityName = defaultCityName;
	}
	
	public City()
	{
		
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}



	public Coordinate getCoordintes() {
		return coordintes;
	}

	public void setCoordintes(Coordinate coordintes) {
		this.coordintes = coordintes;
	}

	
	


}
