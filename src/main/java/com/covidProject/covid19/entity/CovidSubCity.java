package com.covidProject.covid19.entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class CovidSubCity {
	/*
	 * MongoDb class for covid subcity. This will be embedded in states for city name access
	 */
	
	
	private String name;
	private String cityId;

	
	public CovidSubCity() {
			
	}
	
	public CovidSubCity(String name, String cityId) {
		this.name = name;
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}



}
