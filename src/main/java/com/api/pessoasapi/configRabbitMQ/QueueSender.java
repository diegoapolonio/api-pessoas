package com.api.pessoasapi.configRabbitMQ;

import com.api.pessoasapi.dto.PessoaDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class QueueSender {

    @Autowired
    private Queue queue;

    @Autowired
    private SenderConfig senderConfig;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(PessoaDto pessoaDto) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            rabbitTemplate.convertAndSend(this.queue.getName(),objectMapper.writeValueAsString(pessoaDto) );
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
