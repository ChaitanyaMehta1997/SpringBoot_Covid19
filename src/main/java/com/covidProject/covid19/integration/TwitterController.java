package com.covidProject.covid19.integration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class TwitterController {
	
	
	protected String twitter_token = "Bearer AAAAAAAAAAAAAAAAAAAAAEn3OQEAAAAAwMLhmi2ijDlyDQl1CcYoKdhN%2FsA%3D4weGjuPvo4YO4sKJFrML6nI6RSZle3ZuN2UeO85wP2kLrcUN86";
	public void build_request() {

		try {
			
			ArrayList<String> params = new ArrayList<String>(
		            Arrays.asList("oxygen has available")); //Declare query params
			
			Map<String, String> header_map = new HashMap<String, String>(); // declare header params
			header_map.put("Authorization",this.twitter_token);
			
			String url = "https://api.twitter.com/2/tweets/search/recent";
			RestTemplate restTemplate = new RestTemplate();
			

			TwitterConfig configObj = new TwitterConfig(header_map,params,url);
			HttpEntity<?> entity = new HttpEntity<>(configObj.Httpheaders);

			HttpEntity<String> response = restTemplate.exchange(configObj.builder.build().encode().toUri(), HttpMethod.GET,
					entity, String.class);

			System.out.println(response.getBody());
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}