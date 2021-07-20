package com.kumar.registrationService;

import org.axonframework.commandhandling.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.kumar.registrationService.cqrs.command.interceptor.CreateSellerCommandInterceptor;

@SpringBootApplication
public class RegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationServiceApplication.class, args);
	}

	public static final String topicExchangeName = "spring-boot-exchange";
	public static final String queueName = "spring-boot";

	@Autowired
	public void registerCreateCommandSellerInterceptor(ApplicationContext context, CommandBus commandBus) {
		commandBus.registerDispatchInterceptor(context.getBean(CreateSellerCommandInterceptor.class));
	}

	/*
	 * 
	 * You need to configure rabbit for this
	 * 
	 * @Bean Queue queue() { return new Queue(queueName, false); }
	 * 
	 * @Bean TopicExchange exchange() { return new TopicExchange(topicExchangeName);
	 * }
	 * 
	 * @Bean Binding binding(Queue queue, TopicExchange exchange) { return
	 * BindingBuilder.bind(queue).to(exchange).with("foo.bar.#"); }
	 * 
	 * @Bean SimpleMessageListenerContainer container(ConnectionFactory
	 * connectionFactory, MessageListenerAdapter listenerAdapter) {
	 * SimpleMessageListenerContainer container = new
	 * SimpleMessageListenerContainer();
	 * container.setConnectionFactory(connectionFactory);
	 * container.setQueueNames(queueName);
	 * container.setMessageListener(listenerAdapter); return container; }
	 * 
	 * @Bean MessageListenerAdapter listenerAdapter(Receiver receiver) { return new
	 * MessageListenerAdapter(receiver, "receiveMessage"); }
	 */
}
