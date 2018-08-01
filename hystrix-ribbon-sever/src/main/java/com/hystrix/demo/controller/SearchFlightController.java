package com.hystrix.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hystrix.demo.model.Flight;
import com.hystrix.demo.model.Inventory;
import com.hystrix.demo.model.SearchQuery;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class SearchFlightController {
	static final String SEARCH_SERVICE = "http://SEARCH-SERVICE/search";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/searchFlight")
	@HystrixCommand(fallbackMethod="failOver" , commandProperties = {
			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="500")
	})
	public List<Flight> searchFlights(@RequestParam(name="delay",defaultValue="200") Long delay) throws InterruptedException{
		Thread.sleep(delay);
		SearchQuery searchQuery = new SearchQuery("NYC", "SFO", "22-JAN-16");
		Flight[] flights = restTemplate.postForObject(SEARCH_SERVICE + "/get", searchQuery, Flight[].class);
		return Arrays.asList(flights);
	}
	
	public List<Flight> failOver(Long delay){
		List<Flight> flights = new ArrayList<Flight>();
		flights.add(new Flight("KL 987", "IND", "PAK", LocalDate.now().toString(), new com.hystrix.demo.model.Fares("100", "AED"),new Inventory(100)));
		flights.add(new Flight("KL 987", "IND", "PAK", LocalDate.now().toString(), new com.hystrix.demo.model.Fares("100", "AED"),new Inventory(100)));
		return flights;
		
	}

}
