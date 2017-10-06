package com.jcn.weatherapp.model;

import java.io.Serializable;


public class Coordinate implements Serializable{

	
	private long magnitude;
	private long longitude;

	public Coordinate(long magnitude, long longitude) {
		
		this.magnitude = magnitude;
		this.longitude = longitude;
	}

	public long getMagnitude() {
		return magnitude;
	}

	public void setMagnitude(long magnitude) {
		this.magnitude = magnitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

}
