package com.brownfield.pss.checkin.controller;

import org.springframework.stereotype.Component;

@Component 
public class Sender {
	/*
	RabbitMessagingTemplate template;

	@Autowired
	Sender(RabbitMessagingTemplate template){
		this.template = template;
	}
	@Bean
	Queue queue() {
		return new Queue("CheckINQ", false);
	}
	
	public void send(Object message){
		template.convertAndSend("CheckINQ", message);
	}

	 */
}