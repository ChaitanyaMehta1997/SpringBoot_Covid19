package com.covidProject.covid19.entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Information {
	/*
	 * MongoDb class for covid country
	 */
	
	
	@Id private String id;
	private String twitterID;
	private String type;
	private String Info;
	
	public Information() {
			
	}
	
	public Information(String twitterID, String type,String Info) {
		this.twitterID = twitterID;
		this.type = type;
		this.Info = Info;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTwitterID() {
		return twitterID;
	}

	public void setTwitterID(String twitterID) {
		this.twitterID = twitterID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInfo() {
		return Info;
	}

	public void setInfo(String info) {
		Info = info;
	}


}
