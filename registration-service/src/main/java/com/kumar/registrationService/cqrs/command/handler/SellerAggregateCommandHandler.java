package com.kumar.registrationService.cqrs.command.handler;

import java.util.List;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.kumar.registrationService.cqrs.command.CreateSellerCommand;
import com.kumar.registrationService.cqrs.event.SellerCreatedEvent;
import com.kumar.registrationService.model.Item;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class SellerAggregateCommandHandler {

	@AggregateIdentifier
	private String id;
	private String firstName;
	private String lastName;
	private String emailId;
	private List<Item> itemsSold;

	@CommandHandler
	public SellerAggregateCommandHandler(CreateSellerCommand createSellerCommand) {
		// validate createSellerCommand

		SellerCreatedEvent sellerCreatedEvent = new SellerCreatedEvent();
		BeanUtils.copyProperties(createSellerCommand, sellerCreatedEvent);

		AggregateLifecycle.apply(sellerCreatedEvent);
	}

	@EventSourcingHandler
	public void on(SellerCreatedEvent sellerCreatedEvent) {
		this.id = sellerCreatedEvent.getId();
		this.emailId = sellerCreatedEvent.getEmailId();
		this.firstName = sellerCreatedEvent.getFirstName();
		this.lastName = sellerCreatedEvent.getLastName();
		

	}

}
