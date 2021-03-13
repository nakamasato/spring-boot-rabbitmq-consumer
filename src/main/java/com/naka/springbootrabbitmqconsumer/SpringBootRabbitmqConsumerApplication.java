package com.naka.springbootrabbitmqconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootRabbitmqConsumerApplication {

	@Bean
	SimpleMessageListenerContainer container(MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(rabbitConnectionFactory());

		return container;
	}

    @Bean
    public CachingConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory =
            new CachingConnectionFactory(System.getenv("RABBITMQ_HOST"));
        connectionFactory.setUsername(System.getenv("RABBITMQ_USERNAME"));
        connectionFactory.setPassword(System.getenv("RABBITMQ_PASSWORD"));
        return connectionFactory;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitmqConsumerApplication.class, args);
	}

}
