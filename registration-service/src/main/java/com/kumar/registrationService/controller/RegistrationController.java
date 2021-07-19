package com.kumar.registrationService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kumar.registrationService.dto.SellerDTO;
import com.kumar.registrationService.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

	private final RegistrationService registrationService;

	@Autowired
	public RegistrationController(RegistrationService registrationService) {
		// TODO Auto-generated constructor stub
		this.registrationService = registrationService;

	}

	@GetMapping("/sellersList")
	public ResponseEntity<List<SellerDTO>> getSellersList() {
		return new ResponseEntity<>(registrationService.getSellersList(), HttpStatus.OK);
	}

}
