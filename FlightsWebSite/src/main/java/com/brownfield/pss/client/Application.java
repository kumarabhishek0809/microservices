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
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;

import com.brownfield.pss.client.domain.BookingRecord;
import com.brownfield.pss.client.domain.Flight;
import com.brownfield.pss.client.domain.Passenger;
import com.brownfield.pss.client.domain.SearchQuery;

@EnableGlobalMethodSecurity
@SpringBootApplication
@EnableDiscoveryClient // to fetch values from client
public class Application implements CommandLineRunner, UrlConstants {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	RestTemplate restClient = new RestTemplate();

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		// Search for a flight
		SearchQuery searchQuery = new SearchQuery("NYC", "SFO", "22-JAN-16");
		URI flightService = new URI(SEARCH_SERVICE + "get");
		Flight[] flights = restClient.postForObject(flightService, searchQuery, Flight[].class);
		Arrays.asList(flights).forEach(flight -> logger.info(" flight >" + flight));

		// create a booking only if there are flights.
		if (flights == null || flights.length == 0) {
			return;
		}
		Flight flight = flights[0];
		BookingRecord booking = new BookingRecord(flight.getFlightNumber(), flight.getOrigin(), flight.getDestination(),
				flight.getFlightDate(), null, flight.getFares().getFare());
		Set<Passenger> passengers = new HashSet<Passenger>();
		passengers.add(new Passenger("Gavin", "Franc", "Male", booking));
		booking.setPassengers(passengers);
		long bookingId = 0;
		try {
			bookingId = restClient.postForObject(BOOK_SERVICE + "create", booking, long.class);
			logger.info("Booking created " + bookingId);
		} catch (Exception e) {
			logger.error("BOOKING SERVICE NOT AVAILABLE...!!!");
		}

		// check in passenger
		if (bookingId == 0)
			return;
		try {
			CheckInRecord checkIn = new CheckInRecord("Franc", "Gavin", "28C", null, "BF101", "22-JAN-16", bookingId);
			// CheckInRecord checkIn = new CheckInRecord("Franc", "Gavin", "28C", new
			// Date(), "BF101","22-JAN-16", bookingId);
			long checkinId = restClient.postForObject(CHECKIN_SERVICE + "create", checkIn, long.class);
			if (checkinId == -1) { // Added by Kumar
				logger.info("Wrong booking id");
			} else { // end of changes made by Kumar
				logger.info("Checked IN " + checkinId);
			}
		} catch (Exception e) {
			logger.error("CHECK IN SERVICE NOT AVAILABLE...!!!");
		}
	}

}