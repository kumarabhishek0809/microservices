package com.kumar.registrationService.cqrs.command.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kumar.registrationService.cqrs.command.CreateSellerCommand;
import com.kumar.registrationService.model.SellerRestModel;
import com.kumar.registrationService.service.RegistrationService;

@RestController
@RequestMapping("/sellers")
public class SellerCommandController {

	private final RegistrationService registrationService;
	private final CommandGateway commandGateway;

	@Autowired
	public SellerCommandController(RegistrationService registrationService, CommandGateway commandGateway) {
		// TODO Auto-generated constructor stub
		this.registrationService = registrationService;
		this.commandGateway = commandGateway;

	}

	@PostMapping("/add")
	public ResponseEntity<String> createSeller(@Valid @RequestBody SellerRestModel sellerDTO) {
		CreateSellerCommand createSellerCommand = CreateSellerCommand.builder().firstName(sellerDTO.getFirstName()) //
				.emailId(sellerDTO.getEmailId()) //
				.lastName(sellerDTO.getLastName()) //
				.id(UUID.randomUUID().toString()).build();
		String returnCommandValue = "";
		try {
			returnCommandValue = commandGateway.sendAndWait(createSellerCommand);
		} catch (Exception e) {
			System.out.println("returnCommandValue" + e);
		}
		return new ResponseEntity(registrationService.addSeller(sellerDTO) + returnCommandValue, HttpStatus.OK);
	}

}
