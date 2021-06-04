package com.covidProject.covid19.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.covidProject.covid19.entity.CovidCountry;
import com.covidProject.covid19.entity.CovidState;

@Repository
public interface CovidStateRepository extends MongoRepository<CovidState,String> {
	
	List<CovidState> findByName(final String name);
	  
}
	