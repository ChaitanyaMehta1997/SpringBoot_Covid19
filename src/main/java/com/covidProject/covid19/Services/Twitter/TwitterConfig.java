package com.covidProject.covid19.Services.Twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

public class TwitterConfig {

	protected String twitter_token = "YOUR_TOKEN";
	protected String url = "https://api.twitter.com/2/tweets/search/recent";
	protected List<String> parameters = new ArrayList<String>();
	protected Map<String, String> header_params = new HashMap<String, String>();
	protected HttpHeaders Httpheaders;
	protected UriComponentsBuilder builder;
	
	public TwitterConfig() {
		
	}
	public TwitterConfig(Map<String, String> header_map,List<String> parameters, String url) {
			this.header_params = header_map;
			this.url = url;
			this.parameters = parameters;
			this.set_headers();
			this.query_builder();
	}
	
	public TwitterConfig(List<String> parameters,String token, String url) {
		this.twitter_token = token;
		this.url = url;
		this.parameters = parameters;
		this.query_builder();
	}
	
	public void set_headers() {
		/**
		 * Sets headers for the request
		 * Parameters : HashMap of header name and value
		 */
		this.Httpheaders =  new HttpHeaders();
		this.Httpheaders.set("Accept", "application/json");
		for (Map.Entry<String, String> entry : this.header_params.entrySet()) {
			this.Httpheaders.set(entry.getKey(), entry.getValue());
		}	
	}
	
	public void query_builder() {
		this.builder= UriComponentsBuilder.fromHttpUrl(this.url);
		StringBuilder str_parameters = new StringBuilder();
		
		for( String n:parameters){
			str_parameters.append(n);
		} 
		this.builder.queryParam("query", str_parameters);
	}
	
	public void setParam(String param_name,String param_value) {
		this.builder.queryParam("next_token", param_value);
	}
}
