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
	private Information information;
	
	public CovidCity() {
			
	}
	
	public CovidCity(String name,Information information) {
		this.name = name;
		this.information = information;
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

	public Information getInformation() {
		return information;
	}

	public void setInformation(Information information) {
		this.information = information;
	}


}
