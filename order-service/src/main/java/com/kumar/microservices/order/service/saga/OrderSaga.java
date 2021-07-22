package com.kumar.microservices.order.service.saga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import com.kumar.microservices.order.cqrs.event.OrderCreatedEvent;

@Saga
public class OrderSaga {
	@Autowired
	private transient CommandGateway commandGateway;

	@StartSaga
	@SagaEventHandler(associationProperty = "id")
	public void handle(OrderCreatedEvent orderCreatedEvent) {

	}

}
