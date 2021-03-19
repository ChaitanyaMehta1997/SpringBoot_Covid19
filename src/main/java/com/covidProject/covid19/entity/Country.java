package com.covidProject.covid19.entity;
import javax.persistence.*;


@Entity
public class Country {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private long people_vaccinated;
	private long total_population;
	
	public Country() {
		
		
	}
	public Country(String name,long people_vaccinated, long total_population) {
		
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
