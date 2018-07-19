package com.spring.cloud.central.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer // this is to mark that this is centralized server
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
