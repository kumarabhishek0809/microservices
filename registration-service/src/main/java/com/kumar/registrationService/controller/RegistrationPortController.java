package com.kumar.registrationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/registration/port")
public class RegistrationPortController  {

    @Autowired
    private Environment env;

    @GetMapping("/number")
    public ResponseEntity<String> getEnvironmentIP() {
        return new ResponseEntity<>(env.getProperty("local.server.port"), HttpStatus.OK);
    }

}
