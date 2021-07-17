package com.kumar.registrationService.controller;

import java.util.List;
import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kumar.registrationService.command.CreateSellerCommand;
import com.kumar.registrationService.dto.SellerDTO;
import com.kumar.registrationService.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationPortController {

	private final RegistrationService registrationService;
	private final CommandGateway commandGateway;

	@Autowired
	public RegistrationPortController(RegistrationService registrationService, CommandGateway commandGateway) {
		// TODO Auto-generated constructor stub
		this.registrationService = registrationService;
		this.commandGateway = commandGateway;

	}

	@PostMapping("/addSeller")
	public String addSeller(@RequestBody SellerDTO sellerDTO) {
		CreateSellerCommand createSellerCommand = CreateSellerCommand.builder().firstName(sellerDTO.getFirstName()) //
				.emailId(sellerDTO.getEmailId()) //
				.lastName(sellerDTO.getLastName()) //
				.id(UUID.randomUUID().toString()).build();
		String returnCommandValue = "";
		try {
			returnCommandValue = commandGateway.sendAndWait(createSellerCommand);
		} catch (Exception e) {
			System.out.println("returnCommandValue"+e);
		}
		return registrationService.addSeller(sellerDTO) + returnCommandValue;
	}

	@GetMapping("/sellersList")
	public ResponseEntity<List<SellerDTO>> getSellersList() {
		return new ResponseEntity<>(registrationService.getSellersList(), HttpStatus.OK);
	}

}
