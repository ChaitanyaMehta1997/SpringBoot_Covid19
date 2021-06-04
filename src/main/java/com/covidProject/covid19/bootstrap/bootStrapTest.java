package com.covidProject.covid19.bootstrap;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.covidProject.covid19.Repositories.CovidCityRepository;
import com.covidProject.covid19.Repositories.CovidCountryRepository;
import com.covidProject.covid19.Repositories.CovidStateRepository;
import com.covidProject.covid19.entity.CovidCountry;


@Component
public class bootStrapTest implements CommandLineRunner {
	
	
	//private final CountryRepository countryRepo;
	//private final StateRepository stateRepo;
	private final CovidCountryRepository covidCountryRepository;
	private final CovidCityRepository covidCityRepository;
	private final CovidStateRepository covidStateRepository;
	
	public bootStrapTest(CovidCountryRepository covidCountryRepository,CovidCityRepository covidCityRepository, CovidStateRepository covidStateRepository) {

		this.covidCountryRepository = covidCountryRepository;
		this.covidCityRepository = covidCityRepository;
		this.covidStateRepository = covidStateRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*
		Country usa =  new Country("Chaitanya",1000,10000);
		State maharashtra =  new State("Chaitanya");
		
		usa.getLinkedStates().add(maharashtra);
		maharashtra.getLinkedCountry().add(usa);
		
		this.countryRepo.save(usa);
		System.out.println(stateRepo.count());
			 
		
		TwitterController t_obj = new TwitterC ontroller();
		t_obj.build_request();
		
		State maharashtra =  new State("Chaitanya");
		Information info =  new Information(1000,"WHaT is Up");
		
		maharashtra.getLinkedInfo().add(info);
		info.getLinkedStateInfo().add(maharashtra);
		
		this.infoRepo.save(info);
		System.out.println(stateRepo.count());
		 
		
		//TwitterController t_obj = new TwitterController();
		//t_obj.build_request();
		
		final CovidInformation covidInfo = new CovidInformation("YO YO YO","mumbai");

	    final List<CovidInformation> covidInfoList = Arrays.asList(covidInfo);

	    final CovidCountry countrydDoc = new CovidCountry("India","Maharashtra",covidInfoList);
	    this.covidCountryRepository.save(countrydDoc);
	    
	    System.out.println("Find by first name");
	    this.covidCountryRepository.findByName("India").forEach(System.out::println);
	
		
	  
		final List<String> covidInfoList = Arrays.asList("This is a test");
		final CovidCity covidCity = new CovidCity("Mumbai",covidInfoList);
		this.covidCityRepository.save(covidCity);
		final CovidState covidState = new CovidState("Maharashtra",Arrays.asList(covidCity.getId()));
		
	    final CovidCountry countrydDoc = new CovidCountry("India",covidState);
	    this.covidCountryRepository.save(countrydDoc);
	    
	    //System.out.println("Find by first name");
	    //this.covidCountryRepository.findByName("India").forEach(System.out::println);
	     */
	     
	    //TwitterService t_obj = new TwitterService(this.covidCityRepository,this.covidStateRepository,this.covidCountryRepository);
		//t_obj.read_india_states();
		
		List<CovidCountry> Names =  this.covidCountryRepository.findAllNames();
		
		
		for(CovidCountry X: Names) {
			System.out.println(X.getName());
		}
	}
	
	
	
}
