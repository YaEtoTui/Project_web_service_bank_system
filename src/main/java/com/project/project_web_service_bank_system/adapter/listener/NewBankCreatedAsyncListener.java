package com.project.project_web_service_bank_system.adapter.listener;

import com.project.project_web_service_bank_system.domain.event.NewBankCreated;
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
public class NewBankCreatedAsyncListener {
    RabbitService rabbitService;

    @EventListener
    @SneakyThrows
    @Async
    public void handleNewBankCreatedEventAsync(NewBankCreated event) {
        String message = String.format("New bank with name '%s' registered. Time: %s\n", event.getName(), Instant.now());
        rabbitService.sendMessage(message);
        System.out.println(message);
    }
}
