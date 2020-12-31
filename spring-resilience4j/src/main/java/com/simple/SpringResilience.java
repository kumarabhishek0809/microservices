package com.simple;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class SpringResilience {


	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringResilience.class).web(WebApplicationType.SERVLET).run(args);
	}
}
