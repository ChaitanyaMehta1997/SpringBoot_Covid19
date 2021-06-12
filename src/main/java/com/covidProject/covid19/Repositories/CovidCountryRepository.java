package com.covidProject.covid19.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.covidProject.covid19.entity.CovidCountry;

@Repository
public interface CovidCountryRepository extends MongoRepository<CovidCountry,String> {
	
	   @Query(value = "{'name' : ?0}", fields="{'states' : 1, _id:0}")
	   List<CovidCountry> findAllStates(final String name);
	   
	   @Query(value="{}", fields="{'name' : 1, _id:0}")
	   List<CovidCountry> findAllNames();
	
	  //@Query("{'CovidInformation.information': ?0}")
	  //List<CovidCountry> findByInformation(final String information);
	  
}
	