package com.hystrix.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.hystrix.demo.configuration.SimpleRibbonServiceConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableHystrix
@RibbonClient(name = "ribbon-service-2",configuration = SimpleRibbonServiceConfiguration.class)
public class HystrixSeverApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixSeverApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder.build();
	}
}
