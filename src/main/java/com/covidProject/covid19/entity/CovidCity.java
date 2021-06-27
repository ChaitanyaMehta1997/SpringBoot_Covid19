package com.covidProject.covid19.entity;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class CovidCity {
	/*
	 * MongoDb class for covid information
	 */
	
	
	@Id private String id;
	
	private String name;
	private List<Information> information;
	
	//TODO :  add these fields
	private String State;
	private String Country;
	
	public CovidCity() {
			
	}
	
	public CovidCity(String name,List<Information> information,String State,String Country) {
		this.name = name;
		this.State = State;
		this.Country = Country;
		this.information = information;
	}
	
	public CovidCity(String name,String State,String Country) {
		this.name = name;
		this.State = State;
		this.Country = Country;
	}
	
	public CovidCity(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Information> getInformation() {
		return information;
	}

	public void setInformation(List<Information> information) {
		this.information = information;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}


}
