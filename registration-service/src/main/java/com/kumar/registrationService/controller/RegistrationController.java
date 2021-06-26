package com.kumar.registrationService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kumar.registrationService.dto.SellerDto;
import com.kumar.registrationService.service.RegistrationService;


@RestController
@RequestMapping("/registration")
public class RegistrationController  {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/addSeller")
    public String addSeller(@RequestBody SellerDto sellerDto){
        return registrationService.addSeller(sellerDto);
    }

    @GetMapping("/sellersList")
    public ResponseEntity<List<SellerDto>> getSellersList() {
        return new ResponseEntity<>(registrationService.getSellersList(), HttpStatus.OK);
    }

}
