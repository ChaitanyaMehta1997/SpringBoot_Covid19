package com.covidProject.covid19.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.covidProject.covid19.entity.Country;
import com.covidProject.covid19.Repositories.CountryRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/")
@RestController
public class CountryController  {
	
	@Autowired
	private final CountryRepository countryRepository;
	
	public CountryController(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	@RequestMapping("/covid")
	public List<Country> getCountryData(Model model) {
		/*
		 * Returns all data from country table and stores in covid attribute
		 */
		
		
		return (List<Country>) this.countryRepository.findAll();
	}

}
