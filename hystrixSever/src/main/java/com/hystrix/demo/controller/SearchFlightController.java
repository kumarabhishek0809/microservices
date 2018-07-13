package com.hystrix.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hystrix.demo.model.Flight;
import com.hystrix.demo.model.SearchQuery;

@RestController
public class SearchFlightController {
	static final String SEARCH_SERVICE = "http://SEARCH-SERVICE/search";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/searchFlight")
	public List<Flight> searchFlights(Long delay){
		SearchQuery searchQuery = new SearchQuery("NYC", "SFO", "22-JAN-16");
		Flight[] flights = restTemplate.postForObject(SEARCH_SERVICE + "/get", searchQuery, Flight[].class);
		return Arrays.asList(flights);
	}

}
