package com.oauth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class OauthServerApplication {

	@RequestMapping("/resource/endpoint")
	@PreAuthorize("hasRole('ADMIN')")
	public String endPoint() {
		return "This Message is protected by the server";
	}

	@RequestMapping(
			value = "/",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<String> index() {
		return new ResponseEntity<>("{\"message\":\"Home!\"}", HttpStatus.OK);
	}


	public static void main(String[] args) {
		SpringApplication
				.run(OauthServerApplication.class, args);
	}

}
