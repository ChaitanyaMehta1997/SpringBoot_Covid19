package com.covidProject.covid19.Repositories;

import java.util.HashSet;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.covidProject.covid19.entity.CovidCity;
import com.covidProject.covid19.entity.CovidCountry;

@Repository
public interface CovidCityRepository extends MongoRepository<CovidCity,String> {
	
	List<CovidCity> findByName(final String name);
	
	@Query(value="{}", fields="{'name' : 1, _id:0}")
	HashSet<String> findAllNames();
	
	  @Query(value = "{'Country':?0, 'State': ?1 }",fields="{'name' : 1}")
	  List<CovidCity> findAllCities(String countryName, String stateName);
}
	