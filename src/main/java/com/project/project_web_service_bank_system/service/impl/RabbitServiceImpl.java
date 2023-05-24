package com.project.project_web_service_bank_system.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.project_web_service_bank_system.service.RabbitService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class RabbitServiceImpl implements RabbitService {
    ObjectMapper objectMapper;
    RabbitTemplate rabbitTemplate;

    @Override
    @SneakyThrows
    public void sendMessage(Object message) {
        MessageProperties messageProperties = new MessageProperties();

        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);

        Message msg = new Message(objectMapper.writeValueAsBytes(message), messageProperties);

        rabbitTemplate.send("message.queue", msg);
    }
}
