package com.brownfield.pss.checkin.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component 
public class Sender {
	private RabbitMessagingTemplate template;

	@Autowired
	public Sender(RabbitMessagingTemplate template){
		this.template = template;
	}
	@Bean
	public Queue queue() {
		return new Queue("CheckINQ", false);
	}
	
	public void send(Object message){
		template.convertAndSend("CheckINQ", message);
	}

}