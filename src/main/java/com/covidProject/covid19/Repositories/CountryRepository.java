package com.covidProject.covid19.Repositories;

import com.covidProject.covid19.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country,Integer> {

}
