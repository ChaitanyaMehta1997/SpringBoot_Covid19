package com.covidProject.covid19.entity;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Country {
	
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "country_state",
    joinColumns = @JoinColumn(name = "country_id"),
    inverseJoinColumns = @JoinColumn(name = "state_id"))
    Set<State> linkedStates = new HashSet<State>();
	
	
	@Column(nullable = false)
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
	
	public Set<State> getLinkedStates() {
		return this.linkedStates;
	}

	
	
}
