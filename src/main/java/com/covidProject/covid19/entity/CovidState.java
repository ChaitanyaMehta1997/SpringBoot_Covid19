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
	 * MongoDb class for covid country
	 */
	
	
	@Id private String id;
	
	private String name;
	private List<String> city;

	
	public CovidState() {
			
	}
	
	public CovidState(String name, List<String> city) {
		this.name = name;
		this.city = city;
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

	public List<String> getCity() {
		return city;
	}

	public void setCity(List<String> city) {
		this.city = city;
	}




}
