package com.covidProject.covid19.Services.Twitter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.covidProject.covid19.Repositories.CovidCityRepository;
import com.covidProject.covid19.Repositories.CovidCountryRepository;
import com.covidProject.covid19.Repositories.CovidStateRepository;
import com.covidProject.covid19.entity.CovidCity;
import com.covidProject.covid19.entity.CovidCountry;
import com.covidProject.covid19.entity.CovidState;
import com.covidProject.covid19.entity.CovidSubCity;
import com.covidProject.covid19.entity.Information;

@Component
public class TwitterService{

	protected String twitter_token = "Bearer AAAAAAAAAAAAAAAAAAAAAEn3OQEAAAAAgF4zpwmSEnqwA9qFmtc1DK4PBOs%3DVi5RF7NhZIUedG2fEe6AGBo0sMPJiZkqe6rY0hOXkGkENkRLsz";
	private final CovidCityRepository covidCityRepository; 
	private final CovidStateRepository covidStateRepository;
	private final CovidCountryRepository covidCountryRepository;
	 
	
	public TwitterService() {
		this.covidStateRepository = null;
		this.covidCityRepository = null;
		this.covidCountryRepository = null;
	}
	public TwitterService(CovidCityRepository covidCityRepository,CovidStateRepository covidStateRepository,CovidCountryRepository covidCountryRepository) {
		this.covidCityRepository = covidCityRepository;
		this.covidStateRepository = covidStateRepository;
		this.covidCountryRepository = covidCountryRepository;
	}
	
	public void process_request_data(List<String> req_data) {
		
		List<CovidCity> all_cities = covidCityRepository.findAll();
		HashMap<String,CovidCity> cityMap = new HashMap<>();
		
		for(CovidCity city:all_cities) {
			cityMap.put(city.getName().strip().toLowerCase(), city); 
		} 

		String Type = "oyxgen"; // This should be constant
		for(int i = 0;i < req_data.size();i++) {
			String[] current_info = req_data.get(i).split("\\s+");
			CovidCity city = this.checkValidity(current_info, cityMap);
			if(city != null){
				System.out.println("inserted");
				String tweetID = "0";
				Information infoObj = new Information(tweetID,Type,req_data.get(i));
				List<Information> infoList = city.getInformation();
				if(infoList == null) {
					infoList = new ArrayList<>();
				}
				infoList.add(infoObj);
				city.setInformation(infoList);
				this.covidCityRepository.save(city);
			}
		}
		
	}
	
	public CovidCity checkValidity(String [] text_arr,HashMap<String,CovidCity> cityMap) {
		for(int j = 0;j<text_arr.length;j++) {
			if (cityMap.containsKey(text_arr[j].toLowerCase())){
				return cityMap.get(text_arr[j]);
			}
	    }
		return null;
	}
	public String build_request(String paginationToken) {

		try {

			ArrayList<String> params = new ArrayList<String>(Arrays.asList("oxygen has available")); // Declare query params

			Map<String, String> header_map = new HashMap<String, String>(); // declare header params
			header_map.put("Authorization", this.twitter_token);

			String url = "https://api.twitter.com/2/tweets/search/recent";
			RestTemplate restTemplate = new RestTemplate();

			TwitterConfig configObj = new TwitterConfig(header_map, params, url);
			HttpEntity<?> entity = new HttpEntity<>(configObj.Httpheaders);
			if(paginationToken != null) {
				configObj.setParam("new_token", paginationToken);
			}
			
			HttpEntity<String> response = restTemplate.exchange(configObj.builder.build().encode().toUri(),
					HttpMethod.GET, entity, String.class);

			System.out.println(response.getBody().getClass().getName());
			return response.getBody();
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public void read_india_states() throws IOException {
		/**
		 * This function reads the dataset and populates our mongoDB database.
		 * 
		 */
		String line = "";
		String splitBy = ",";
		String path = ".\\src\\main\\java\\com\\covidProject\\covid19\\Datasets\\Indian Cities Database.csv";
		HashMap<String, List<String>> state_city = new HashMap<>();
		
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] info = line.split(splitBy); // use comma as separator
				String City = info[0].toLowerCase();
				String State = info[5].toLowerCase();

				if (state_city.get(State) == null) {
					List<String> temp_list = new ArrayList<>();
					temp_list.add(City);
					state_city.put(State, temp_list);
				} else {
					List<String> temp_list = state_city.get(State);
					temp_list.add(City);
					state_city.put(State, temp_list);
				}
			}

			List<Document> list = new ArrayList<Document>();
			
			//Initialize country
			CovidCountry countryDoc = new CovidCountry();
			countryDoc.setName("India");
			
			//Initialize state list
			List<CovidState> states_list = new ArrayList<>();
			
			for (Map.Entry<String, List<String>> entry : state_city.entrySet()) {
				
				//get state and cities from the map we created 
				String state = entry.getKey();
				List<String> cities = entry.getValue();

				List<CovidSubCity> city_list = new ArrayList<>();

				//Cities are created before states.
				for (String city : cities) {
					CovidCity covidCity = new CovidCity(city,state,countryDoc.getName());
					this.covidCityRepository.save(covidCity);
					CovidSubCity subCity = new CovidSubCity(city,covidCity.getId());
					city_list.add(subCity);
				}
				
				
				
				//create state
				CovidState covidState = new CovidState(state,city_list);
				//this.covidStateRepository.save(covidState);
			
				
				states_list.add(covidState);
				
			}
			countryDoc.setStates(states_list);
			this.covidCountryRepository.save(countryDoc);
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
