package com.project.project_web_service_bank_system.adapter.listener;

import com.project.project_web_service_bank_system.domain.event.NewAccountCreated;
import com.project.project_web_service_bank_system.service.RabbitService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Instant;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class NewAccountCreatedAsyncListener {
    RabbitService rabbitService;

    @EventListener
    @SneakyThrows
    @Async
    public void handleNewAccountCreatedEventAsync(NewAccountCreated event) {
        String message = String.format("New account with id '%s', username '%s', role '%s'  registered. Time: %s",
                event.getId(), event.getUsername(), event.getRole(), Instant.now());
        rabbitService.sendMessage(message);
        System.out.println(message);
    }
}
