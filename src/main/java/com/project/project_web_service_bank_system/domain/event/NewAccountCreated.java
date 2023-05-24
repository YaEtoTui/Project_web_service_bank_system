package com.project.project_web_service_bank_system.domain.event;

import com.project.project_web_service_bank_system.domain.entity.Account;
import lombok.Value;

/*
Класс, чтобы мы могли передать в listeners и как-то с ним паработать
 */

@Value
public class NewAccountCreated {
    Long id;
    String username;
    String role;

    public static NewAccountCreated from(Account account) {
        return new NewAccountCreated(account.getId(), account.getUsername(), account.getRole());
    }
}
