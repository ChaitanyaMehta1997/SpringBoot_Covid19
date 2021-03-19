package com.covidProject.covid19.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.covidProject.covid19.Repositories.CountryRepository;
import com.covidProject.covid19.entity.Country;


@Component
public class bootStrapTest implements CommandLineRunner {
	
	
	private final CountryRepository countryRepo;
	
	public bootStrapTest(CountryRepository countryRepo) {
		
		this.countryRepo = countryRepo;
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Country usa =  new Country("Chaitanya",1000,10000);
		countryRepo.save(usa);
		System.out.println(countryRepo.count());
	}
	
	
	
}
