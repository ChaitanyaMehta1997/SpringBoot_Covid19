package com.covidProject.covid19.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covidProject.covid19.Repositories.CovidCountryRepository;
import com.covidProject.covid19.entity.Country;
import com.covidProject.covid19.entity.CovidCountry;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/")
@RestController
public class CountryController  {
	/*
	@Autowired
	private final CountryRepository countryRepository;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	private static final String KafkaTopic = "kafka_covid_stream";
	
	public CountryController(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
	
	@RequestMapping("/covid")
	public List<Country> getCountryData(Model model) {
		
		
		
		return (List<Country>) this.countryRepository.findAll();
	}
	
	@RequestMapping("/covidstream")
	public String postCountryData() {
		//KafkaTemplate.send(KafkaTopic,"HEYY");
		return "";
	}
	**/
	@Autowired
	private final CovidCountryRepository covidCountryRepository;
	
	public CountryController(CovidCountryRepository covidCountryRepository) {
		this.covidCountryRepository = covidCountryRepository;
	}
	
	@RequestMapping("/api/covid/country")
	public List<CovidCountry> getCountryNames() {
		return this.covidCountryRepository.findAllNames(); 
	}
}
