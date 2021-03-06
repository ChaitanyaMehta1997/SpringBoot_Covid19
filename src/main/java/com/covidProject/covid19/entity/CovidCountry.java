package com.covidProject.covid19.entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class CovidCountry {
	/*
	 * MongoDb class for covid country
	 */
	
	
	@Id private String id;
	private String name;
	private List<CovidState> states;

	
	public CovidCountry() {
			
	}
	
	public CovidCountry(String name,List<CovidState> states) {
		this.name = name;
		this.states = states;
	}

	public CovidCountry(String string) {
		// TODO Auto-generated constructor stub
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

	public List<CovidState> getStates() {
		return states;
	}

	public void setStates(List<CovidState> states) {
		this.states = states;
	}



}
