package com.covidProject.covid19.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covidProject.covid19.entity.CovidCountry;
import com.covidProject.covid19.entity.State;
import com.covidProject.covid19.Repositories.CovidStateRepository;
import com.covidProject.covid19.Repositories.StateRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/")
@RestController
public class StateController  {
	/*
	@Autowired
	private final StateRepository stateRepository;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	

	public StateController(StateRepository countryRepository) {
		this.stateRepository = countryRepository;
	}
	
	@RequestMapping("/covidStates")
	public List<State> getCountryData(Model model) {

		
		return (List<State>) this.stateRepository.findAll();
		*/
	@Autowired
	private final CovidStateRepository covidStateRepository;
	
	public StateController(CovidStateRepository covidStateRepository) {
		this.covidStateRepository = covidStateRepository;
	}
	

	}


