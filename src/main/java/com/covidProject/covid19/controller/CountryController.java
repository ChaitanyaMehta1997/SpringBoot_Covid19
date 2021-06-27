package com.covidProject.covid19.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covidProject.covid19.Repositories.CovidCountryRepository;
import com.covidProject.covid19.entity.Country;
import com.covidProject.covid19.entity.CovidCity;
import com.covidProject.covid19.entity.CovidCountry;
import com.covidProject.covid19.entity.CovidState;
import com.covidProject.covid19.entity.CovidSubCity;

@CrossOrigin(origins="http://localhost:3000")
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
	
	@RequestMapping("/country")
	public List<CovidCountry> getCountryNames() {
		
		return this.covidCountryRepository.findAllNames();
	}
	
	@GetMapping("/{CountryName}/states")
	public List<String> getStateInfo(@PathVariable String CountryName) {
		
		List<CovidCountry> Country =  this.covidCountryRepository.findAllStates(CountryName);
		System.out.print("Called");
		//TODO: check if you will need the ID's in the future
		List<String> idStates = new ArrayList<>();
		List<CovidState> allStates = Country.get(0).getStates();
		for(CovidState state:allStates){
			
			idStates.add(state.getName());
		}
		return idStates;
	}
	
	
	
}
