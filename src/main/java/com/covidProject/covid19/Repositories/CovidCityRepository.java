package com.covidProject.covid19.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.covidProject.covid19.entity.CovidCity;

@Repository
public interface CovidCityRepository extends MongoRepository<CovidCity,String> {
	
	List<CovidCity> findByName(final String name);
	  
}
	