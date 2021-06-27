package com.covidProject.covid19.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.covidProject.covid19.Repositories.CovidCityRepository;
import com.covidProject.covid19.Repositories.CovidCountryRepository;
import com.covidProject.covid19.Repositories.CovidStateRepository;
import com.covidProject.covid19.Services.Twitter.TwitterService;
import com.twitter.twittertext.Extractor;


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
		TwitterService t_obj = new TwitterService(this.covidCityRepository,this.covidStateRepository,this.covidCountryRepository);
		//t_obj.read_india_states();
		
	}
	
	public void queryTwitter() {
		// TODO Auto-generated method stub
		
				String new_token = null;
				for(int j = 0; j<10;j++) {
					TwitterService t_obj = new TwitterService(this.covidCityRepository,this.covidStateRepository,this.covidCountryRepository);
					
						
					String res = t_obj.build_request(new_token);
					
					JSONObject root =  new JSONObject(res);
					JSONArray json_obj =  root.getJSONArray("data");
					//Process
					List<String> tweetList = new ArrayList<>();
					
					// get pagination token
					if(!root.getJSONObject("meta").isNull("new_token")) {
						new_token = root.getJSONObject("meta").getString("next_token");
					}
					else {
						break;
					}

					//System.out.println(new_token);
					for(int i=0;i<json_obj.length()-1;i++) {
						String tweet = json_obj.getJSONObject(i).get("text").toString();
						String not_allowed = new String("RTuy");
						if(!tweet.substring(0, 2).equals(not_allowed)) {
							tweetList.add(tweet);
						}
					}
					//tweetList.add("This is a test agra");
					t_obj.process_request_data(tweetList);
				}
	}
	
	
}
