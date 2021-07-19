package com.kumar.registrationService.aggregator;

import java.util.List;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.kumar.registrationService.command.CreateSellerCommand;
import com.kumar.registrationService.dto.Item;
import com.kumar.registrationService.event.SellerCreatedEvent;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class SellerAggregate {

	@AggregateIdentifier
	private String id;
	private String firstName;
	private String lastName;
	private String emailId;
	private List<Item> itemsSold;

	@CommandHandler
	public SellerAggregate(CreateSellerCommand createSellerCommand) {
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
