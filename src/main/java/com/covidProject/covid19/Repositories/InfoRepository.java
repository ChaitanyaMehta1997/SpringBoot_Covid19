package com.covidProject.covid19.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.covidProject.covid19.entity.CovidState;

public interface InfoRepository extends MongoRepository<CovidState,String>  {
	
}
