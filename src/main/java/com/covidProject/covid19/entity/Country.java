package com.covidProject.covid19.entity;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Country {
	
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private Long id;
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;
	
	private String name;
	private long people_vaccinated;
	private long total_population;
	
	public Country() {
		
		
	}
	public Country(String name,long people_vaccinated, long total_population) {
		this.name = name;
		this.people_vaccinated = people_vaccinated;
		this.total_population = total_population;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPeople_vaccinated() {
		return people_vaccinated;
	}

	public void setPeople_vaccinated(long people_vaccinated) {
		this.people_vaccinated = people_vaccinated;
	}

	public double getTotal_population() {
		return total_population;
	}

	public void setTotal_population(long total_population) {
		this.total_population = total_population;
	}
	
	
	
}
