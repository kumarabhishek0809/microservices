package com.kumar.registrationService.cqrs.command;

import java.util.List;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.kumar.registrationService.model.Item;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateSellerCommand {
	@TargetAggregateIdentifier
	private final String id;
	private final String firstName;
	private final String lastName;
	private final String emailId;
	private List<Item> itemsSold;

}
