package com.kumar.registrationService.cqrs.event;

import java.util.List;

import com.kumar.registrationService.model.Item;

import lombok.Data;

@Data
public class SellerCreatedEvent {

	private String id;
	private String firstName;
	private String lastName;
	private String emailId;
	private List<Item> itemsSold;

}
