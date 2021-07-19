package com.kumar.registrationService.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SellerRestModel {
	
	private String id;
	
	@NotBlank(message = "First Name is a required Field")
	private String firstName;
	private String lastName;
	private String emailId;
	private List<Item> itemsSold;

}
