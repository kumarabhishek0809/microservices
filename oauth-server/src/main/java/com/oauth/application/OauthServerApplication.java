package com.oauth.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableDiscoveryClient // For Client Discovery on Eureka
@EnableAuthorizationServer // For No of Default End Points
public class OauthServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(OauthServerApplication.class, args);
	}
}
