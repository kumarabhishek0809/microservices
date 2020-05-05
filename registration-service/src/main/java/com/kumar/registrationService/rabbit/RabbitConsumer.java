package com.kumar.registrationService.rabbit;

import com.kumar.registrationService.model.Person;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

@Service
public class RabbitConsumer {

   // @RabbitListener(queues = "Mobile")
    public void getMessageMobile(Person person) {
        System.out.println(person.getName());
    }


    //@RabbitListener(queues = "AC")
    public void getMessageAc(byte[] message) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bas = new ByteArrayInputStream(message);
        ObjectInput oi = new ObjectInputStream(bas);
        Person p = (Person) oi.readObject();
        oi.close();
        bas.close();
        System.out.println(p.getName());
    }
}
