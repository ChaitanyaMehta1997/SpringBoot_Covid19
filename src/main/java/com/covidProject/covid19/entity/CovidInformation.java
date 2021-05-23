package com.covidProject.covid19.entity;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class CovidInformation {
	/*
	 * MongoDb class for covid information
	 */
	
	
	 @Id private String id;
	
	private String information;
	private String city;
	
	public CovidInformation() {
			
	}
	
	public CovidInformation(String information,String city) {
		this.information = information;
		this.city = city;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	
	
}
