package com.covidProject.covid19.entity;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Information {
	
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID id;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "state_info",
    joinColumns = @JoinColumn(name = "state_id"),
    inverseJoinColumns = @JoinColumn(name = "info_id"))
    Set<State> linkedStateInfo = new HashSet<State>();
	
	
	@Column(nullable = false)
	private long twitter_id;
	private String info;
	private long total_population;
	
	public Information() {
		
		
	}
	public Information(long twitter_id,String info) {
		this.twitter_id = twitter_id;
		this.info = info;
	}
	public Set<State> getLinkedStateInfo() {
		return linkedStateInfo;
	}
	public void setLinkedStateInfo(Set<State> linkedStateInfo) {
		this.linkedStateInfo = linkedStateInfo;
	}
	public long getTwitter_id() {
		return twitter_id;
	}
	public void setTwitter_id(long twitter_id) {
		this.twitter_id = twitter_id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public long getTotal_population() {
		return total_population;
	}
	public void setTotal_population(long total_population) {
		this.total_population = total_population;
	}
	
	
	
	
}
