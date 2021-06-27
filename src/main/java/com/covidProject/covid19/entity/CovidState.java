package com.covidProject.covid19.entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class CovidState {
	/*
	 * MongoDb class for covid state
	 *             {
	 *             	   name:
	 *                 city : [{name:___ , id:___ }]          
	 *             }
	 */
	
	
	@Id private String id;
	
	private String name;
	private List<CovidSubCity> city;

	
	public CovidState() {
			
	}
	
	public CovidState(String name, List<CovidSubCity> city_list) {
		this.name = name;
		this.city = city_list;
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

	public List<CovidSubCity> getCity() {
		return city;
	}

	public void setCity(List<CovidSubCity> city) {
		this.city = city;
	}




}
