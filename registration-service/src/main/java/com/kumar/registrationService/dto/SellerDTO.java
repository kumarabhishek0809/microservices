package com.kumar.registrationService.dto;

import java.util.List;

import lombok.Data;

@Data
public class SellerDTO {

	private long id;

	private String firstName;

	private String lastName;

	private String emailId;

	private List<Item> itemsSold;

	

}
