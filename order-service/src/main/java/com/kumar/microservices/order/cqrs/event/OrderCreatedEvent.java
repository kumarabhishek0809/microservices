package com.kumar.microservices.order.cqrs.event;

import lombok.Data;

@Data
public class OrderCreatedEvent {

	private String id;
	private String firstName;
	private String lastName;
	private String emailId;

}
