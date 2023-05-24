package com.project.project_web_service_bank_system.adapter.listener;

import com.project.project_web_service_bank_system.domain.event.NewBankCardCreated;
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
public class NewBankCardCreatedAsyncListener {
    RabbitService rabbitService;

    @EventListener
    @SneakyThrows
    @Async
    public void handleNewBankCardCreatedEventAsync(NewBankCardCreated event) {
        String message = String.format("New card with id '%s', number '%s', CVV '%s' registered. Time: %s\n",
                event.getId(), event.getNumber(), event.getCVV(), Instant.now());
        rabbitService.sendMessage(message);
        System.out.println(message);
    }
}
