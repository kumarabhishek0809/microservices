package com.oauth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@RestController
public class OauthServerApplication {

	@RequestMapping("/resouce/enpoint")
	public String endPoint() {
		return "This Message is protected by the server";
	}

	public static void main(String[] args) {
		SpringApplication.run(OauthServerApplication.class, args);
	}

}
