package com.naka.springbootrabbitmqconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
	}
}
