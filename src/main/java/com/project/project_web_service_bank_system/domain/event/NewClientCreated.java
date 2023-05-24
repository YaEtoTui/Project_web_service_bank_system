package com.project.project_web_service_bank_system.domain.event;

import com.project.project_web_service_bank_system.domain.entity.Client;
import lombok.Value;

/*
Класс, чтобы мы могли передать в listeners и как-то с ним паработать
 */

@Value
public class NewClientCreated {
    Long id;
    String name;
    Integer age;

    public static NewClientCreated from(Client client) {
        return new NewClientCreated(
                client.getId(),
                client.getName(),
                client.getAge()
        );
    }
}
