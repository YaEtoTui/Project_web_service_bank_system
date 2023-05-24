package com.project.project_web_service_bank_system.domain.event;

import com.project.project_web_service_bank_system.domain.entity.Bank;
import lombok.Value;

/*
Класс, чтобы мы могли передать в listeners и как-то с ним паработать
 */

@Value
public class NewBankCreated {
    Long id;
    String name;

    public static NewBankCreated from(Bank bank) {
        return new NewBankCreated(bank.getId(), bank.getName());
    }
}
