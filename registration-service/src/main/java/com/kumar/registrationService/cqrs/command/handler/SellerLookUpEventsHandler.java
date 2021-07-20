package com.kumar.registrationService.cqrs.command.handler;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.kumar.registrationService.cqrs.event.SellerCreatedEvent;
import com.kumar.registrationService.entity.SellerLookUpEntity;
import com.kumar.registrationService.repository.SellerLookUpRepository;

@Component
@ProcessingGroup("seller-group")
public class SellerLookUpEventsHandler {

	private final SellerLookUpRepository sellerLookUpRepository;

	public SellerLookUpEventsHandler(SellerLookUpRepository sellerLookUpRepository) {
		this.sellerLookUpRepository = sellerLookUpRepository;
	}

	@EventHandler
	public void on(SellerCreatedEvent sellerCreatedEvent) {
		SellerLookUpEntity sellerLookUpEntity = new SellerLookUpEntity(sellerCreatedEvent.getId(),
				sellerCreatedEvent.getEmailId());
		sellerLookUpRepository.save(sellerLookUpEntity);

	}

}
