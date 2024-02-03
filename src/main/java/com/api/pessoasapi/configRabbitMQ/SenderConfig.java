package com.api.pessoasapi.configRabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SenderConfig {
    @Value("${spring.rabbitmq.queue}")
    private String message;
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory){
        final var rabbitTemplete= new RabbitTemplate(connectionFactory);
        rabbitTemplete.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplete;
    }
    @Bean
    public MessageConverter
    producerJackson2MessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue queue() {
        return new Queue(message, true);
    }

}
