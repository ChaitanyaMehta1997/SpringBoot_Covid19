package com.covidProject.covid19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.covidProject.covid19.Repositories.CovidCountryRepository;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class Covid19Application {

	public static void main(String[] args) {
		SpringApplication.run(Covid19Application.class, args);
	}

}
