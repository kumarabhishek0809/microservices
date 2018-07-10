package com.brownfield.pss.checkin;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.brownfield.pss.checkin.component.CheckinComponent;
import com.brownfield.pss.checkin.entity.CheckInRecord;

@SpringBootApplication
@EnableDiscoveryClient
public class Application implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	private CheckinComponent checkinComponent;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}
	

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder.build();
	}
	
	@Override
	public void run(String... strings) throws Exception {
		CheckInRecord record = new CheckInRecord("Franc", "Gean","28A",new Date(),"BF101","22-JAN-16",1);
		if(checkinComponent.checkIn(record) == -1){ 
			logger.info("Wrong booking id "+ record.getBookingId());
		}
		
		if(checkinComponent.checkIn(record) == -2){ 
			logger.info("Already checkd In against booking id "+ record.getBookingId());
		}
	}
}
