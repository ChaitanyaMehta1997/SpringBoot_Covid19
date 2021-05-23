package com.covidProject.covid19.entity;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class State {
	
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "linkedStates")
    Set<Country> linkedCountry = new HashSet<Country>();
	
	@Column(nullable = false,columnDefinition = "VARCHAR(255)")
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "linkedStateInfo")
    Set<Information> linkedInfo = new HashSet<Information>();
	
	public State() {	
	}
	
	public State(String name) {
		this.name = name;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Country> getLinkedCountry() {
		return linkedCountry;
	}

	public void setLinkedCountry(Set<Country> linkedCountry) {
		this.linkedCountry = linkedCountry;
	}

	public Set<Information> getLinkedInfo() {
		return linkedInfo;
	}

	public void setLinkedInfo(Set<Information> linkedInfo) {
		this.linkedInfo = linkedInfo;
	}
	
	



	
}
