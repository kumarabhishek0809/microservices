package com.kumar.registrationService.rabbit;

import com.kumar.registrationService.RegistrationServiceApplication;
import com.kumar.registrationService.model.Person;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;


@Component
public class Runner { //implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    //@Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        for(int i = 0; i<10000; i++) {
            Person person = new Person(i, "Name :::" + i);
            rabbitTemplate.convertAndSend("Mobile", person);
            rabbitTemplate.convertAndSend("Direct-Exchange", "mobile", person);
            rabbitTemplate.convertAndSend("Fanout-Exchange", "", person);
            rabbitTemplate.convertAndSend("Topic-Exchange", "tv.mobile.ac", person);
            rabbitTemplate.convertAndSend("Topic-Exchange", "kumar.tv.exchange", person);
            rabbitTemplate.convertAndSend(RegistrationServiceApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
        }

        for(int i = 0; i<10000; i++) {
            Person person = new Person(i, "Name :::" + i);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(person);
            out.flush();
            out.close();

            byte[] byteMessage = bos.toByteArray();
            bos.close();

            Message message = MessageBuilder.withBody(byteMessage).setHeader("item1", "Mobile").setHeader("item2", "television").build();

            rabbitTemplate.send("Headers-Exchange", message);
        }

        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }
}

