package com.zull.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.zull.proxy.filter.OAuthFilter;
import com.zull.proxy.filter.ThrottlingFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class APIGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(APIGatewayApplication.class, args);
    }

    @Bean
    public OAuthFilter oAuthFilter() {
        return new OAuthFilter();
    }

    @Bean
    public ThrottlingFilter throttlingFilter() {
        return new ThrottlingFilter();
    }

}
