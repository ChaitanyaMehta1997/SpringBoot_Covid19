package com.covidProject.covid19.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covidProject.covid19.Repositories.CovidCityRepository;
import com.covidProject.covid19.Repositories.CovidCountryRepository;
import com.covidProject.covid19.entity.Country;
import com.covidProject.covid19.entity.CovidCity;
import com.covidProject.covid19.entity.CovidCountry;
import com.covidProject.covid19.entity.CovidState;
import com.covidProject.covid19.entity.CovidSubCity;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class CityController  {

	@Autowired
	private final CovidCityRepository covidCityRepository;
	
	public CityController(CovidCityRepository covidCityRepository) {
		this.covidCityRepository = covidCityRepository;
	}
	

	@GetMapping("/{CountryName}/states/{stateName}")
	public List<CovidCity> getCityNames(@PathVariable String CountryName,@PathVariable String stateName) {
		System.out.println(CountryName+stateName);
		
		List<CovidCity> CityInfo =  this.covidCityRepository.findAllCities(CountryName,stateName);
		System.out.println(CityInfo.size());
		
		
		return CityInfo;
	}
	
	
}
