package com.kumar.registrationService.cqrs.event.handler;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kumar.registrationService.cqrs.event.SellerCreatedEvent;
import com.kumar.registrationService.entity.SellerEntity;
import com.kumar.registrationService.repository.SellerRepository;

@Component
public class SellerEventHandler {

	private final SellerRepository sellerRepository;

	@Autowired
	public SellerEventHandler(SellerRepository sellerRepository) {
		this.sellerRepository = sellerRepository;
	}

	@EventHandler
	public void on(SellerCreatedEvent sellerCreatedEvent) {
		SellerEntity sellerEntity = new SellerEntity();
		BeanUtils.copyProperties(sellerCreatedEvent, sellerEntity);
		sellerRepository.save(sellerEntity);
	}

}
