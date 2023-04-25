package com.amqp.config;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class RabbitMQConfig {

    private final ConnectionFactory connectionFactory;

    /*
    s used to send messages to a RabbitMQ exchange. It sets the message converter to be a
    Jackson2JsonMessageConverter instance, which converts messages to and from JSON format.
     */
    @Bean
    public AmqpTemplate amqpTemplate(){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jacksonConvertor());
        return rabbitTemplate;
    }

    // receive message from the queues
    @Bean
    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(jacksonConvertor());
        return factory;
    }

    /*
        method creates and returns an instance of the Jackson2JsonMessageConverter class,
        which is responsible for converting messages to and from JSON format.
     */
    @Bean
    public MessageConverter jacksonConvertor(){
        return new Jackson2JsonMessageConverter();
    }
}
