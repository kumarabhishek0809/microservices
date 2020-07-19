package com.kumar.registrationService.controller;

import com.kumar.registrationService.dto.SellerDto;
import com.kumar.registrationService.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/registration")
@EnableResourceServer
@EnableWebSecurity
public class RegistrationController   extends WebSecurityConfigurerAdapter {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/addSeller")
    public String addSeller(@RequestBody SellerDto sellerDto){
        return registrationService.addSeller(sellerDto);
    }

    @GetMapping("/sellersList")
    public List<SellerDto> getSellersList() {
        return registrationService.getSellersList();
    }

    @Bean
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId("orderprocessingservice");
        tokenServices.setClientSecret("orderprocessingservicesecret");
        tokenServices.setCheckTokenEndpointUrl("http://localhost:8085/oauth/check_token");
        return tokenServices;
    }

    @Override
    public AuthenticationManager authenticationManagerBean() {
        OAuth2AuthenticationManager authenticationManager = new OAuth2AuthenticationManager();
        authenticationManager.setTokenServices(tokenServices());
        return authenticationManager;
    }
}
