package com.covidProject.covid19.Services.Twitter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

@Component
public class TwitterService {

	protected String twitter_token = "YOUR_TOKEN";
	private final CovidCityRepository covidCityRepository; 
	private final CovidStateRepository covidStateRepository;
	private final CovidCountryRepository covidCountryRepository;
	 
	
	public TwitterService() {
		this.covidStateRepository = null;
		this.covidCityRepository = null;
		this.covidCountryRepository = null;
	}
	public TwitterService(CovidCityRepository covidCityRepository,CovidStateRepository covidStateRepository,CovidCountryRepository covidCountryRepository ) {
		this.covidCityRepository = covidCityRepository;
		this.covidStateRepository = covidStateRepository;
		this.covidCountryRepository = covidCountryRepository;
	}
	
	public String build_request() {

		try {

			ArrayList<String> params = new ArrayList<String>(Arrays.asList("oxygen has available")); // Declare query params

			Map<String, String> header_map = new HashMap<String, String>(); // declare header params
			header_map.put("Authorization", this.twitter_token);

			String url = "https://api.twitter.com/2/tweets/search/recent";
			RestTemplate restTemplate = new RestTemplate();

			TwitterConfig configObj = new TwitterConfig(header_map, params, url);
			HttpEntity<?> entity = new HttpEntity<>(configObj.Httpheaders);

			HttpEntity<String> response = restTemplate.exchange(configObj.builder.build().encode().toUri(),
					HttpMethod.GET, entity, String.class);

			System.out.println(response.getBody());
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

				List<String> city_list = new ArrayList<>();

				//Cities are created before states.
				for (String city : cities) {
					CovidCity covidCity = new CovidCity(city);
					this.covidCityRepository.save(covidCity);
					city_list.add(covidCity.getId());
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
