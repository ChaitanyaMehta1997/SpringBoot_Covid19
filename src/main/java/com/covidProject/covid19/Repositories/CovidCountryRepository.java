package com.covidProject.covid19.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.covidProject.covid19.entity.CovidCountry;

@Repository
public interface CovidCountryRepository extends MongoRepository<CovidCountry,String> {
	
	   List<CovidCountry> findByName(final String name);

	
	  //@Query("{'CovidInformation.information': ?0}")
	  //List<CovidCountry> findByInformation(final String information);
	  
}
	