package com.brownfield.pss.client;

import java.net.URI;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;

import com.brownfield.pss.client.domain.BookingRecord;
import com.brownfield.pss.client.domain.Flight;
import com.brownfield.pss.client.domain.Passenger;
import com.brownfield.pss.client.domain.SearchQuery;

@EnableGlobalMethodSecurity
@SpringBootApplication 
@EnableDiscoveryClient // to fetch values from client
public class Application implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

   	RestTemplate searchClient = new RestTemplate();
	
  	 RestTemplate bookingClient = new RestTemplate();
	
   	RestTemplate checkInClient = new RestTemplate();
	
	 RestTemplate restClient= new RestTemplate();
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	 
	@Override
	public void run(String... strings) throws Exception {
		//Search for a flight
		SearchQuery searchQuery = new SearchQuery("NYC","SFO","22-JAN-16");
		URI flightService = new URI("http://search-service/search/get");
 		Flight[] flights = searchClient.postForObject(flightService, searchQuery, Flight[].class); 
		Arrays.asList(flights).forEach(flight -> logger.info(" flight >"+ flight));
  		
		//create a booking only if there are flights.
 		if(flights == null || flights.length == 0){
 			return;
 		}
		Flight flight = flights[0];
		BookingRecord booking = new BookingRecord(flight.getFlightNumber(),flight.getOrigin(),
												  flight.getDestination(), flight.getFlightDate(),null,
												  flight.getFares().getFare());
		Set<Passenger> passengers = new HashSet<Passenger>();
		passengers.add(new Passenger("Gavin","Franc","Male", booking));
		booking.setPassengers(passengers);
		long bookingId =0;
		try { 
			 bookingId = bookingClient.postForObject("http://book-service/booking/create", booking, long.class); 
//			 bookingId = bookingClient.postForObject("http://localhost:8060/booking/create", booking, long.class); 
			logger.info("Booking created "+ bookingId);
		}catch (Exception e){
			logger.error("BOOKING SERVICE NOT AVAILABLE...!!!");
		}
		
		//check in passenger
		if(bookingId == 0) return;
		try {
			CheckInRecord checkIn = new CheckInRecord("Franc", "Gavin", "28C", null, "BF101","22-JAN-16", bookingId);
//			CheckInRecord checkIn = new CheckInRecord("Franc", "Gavin", "28C", new Date(), "BF101","22-JAN-16", bookingId);
			long checkinId = checkInClient.postForObject("http://localhost:8070/checkin/create", checkIn, long.class);
			if(checkinId == -1){ //Added by Kumar
				logger.info("Wrong booking id");
			}else{ //end of changes made by Kumar
				logger.info("Checked IN "+ checkinId);
			}
		}catch (Exception e){
			logger.error("CHECK IN SERVICE NOT AVAILABLE...!!!"); 
		}
	}
		 
}