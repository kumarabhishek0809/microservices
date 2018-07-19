package com.zull.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.zull.proxy.filter.CustomZuulFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient 
public class Application {
	
	@Bean
	public CustomZuulFilter proxyRequestHelper() {
	   return new CustomZuulFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
