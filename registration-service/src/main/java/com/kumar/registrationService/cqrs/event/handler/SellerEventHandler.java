package com.kumar.registrationService.cqrs.event.handler;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kumar.registrationService.cqrs.event.SellerCreatedEvent;
import com.kumar.registrationService.entity.SellerEntity;
import com.kumar.registrationService.repository.SellerRepository;

@Component
@ProcessingGroup("seller-group")
public class SellerEventHandler {

	private final SellerRepository sellerRepository;

	@Autowired
	public SellerEventHandler(SellerRepository sellerRepository) {
		this.sellerRepository = sellerRepository;
	}

	@ExceptionHandler(resultType = IllegalArgumentException.class)
	public void handle(IllegalArgumentException e) {

	}

	@EventHandler
	public void on(SellerCreatedEvent sellerCreatedEvent) {
		SellerEntity sellerEntity = new SellerEntity();
		BeanUtils.copyProperties(sellerCreatedEvent, sellerEntity);
		try {
			sellerRepository.save(sellerEntity);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
