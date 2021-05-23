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
	private String state;
	private List<CovidInformation> covidinformation;
	
	public CovidCountry() {
			
	}
	
	public CovidCountry(String name, String state, List<CovidInformation> covidinformation) {
		this.name = name;
		this.setCovidinformation(covidinformation);
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public List<CovidInformation> getCovidinformation() {
		return covidinformation;
	}

	public void setCovidinformation(List<CovidInformation> covidinformation) {
		this.covidinformation = covidinformation;
	}

	
	
}
