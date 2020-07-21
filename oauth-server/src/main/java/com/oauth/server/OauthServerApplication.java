package com.oauth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class OauthServerApplication {

	public static void main(String[] args) {
		SpringApplication
				.run(OauthServerApplication.class, args);
	}

}
