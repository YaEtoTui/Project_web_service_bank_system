package com.project.project_web_service_bank_system.domain.event;

import com.project.project_web_service_bank_system.domain.entity.BankCard;
import lombok.Value;

/*
Класс, чтобы мы могли передать в listeners и как-то с ним паработать
 */

@Value
public class NewBankCardCreated {
    Long id;
    Long number;
    int CVV;

    public static NewBankCardCreated from(BankCard bankCard) {
        return new NewBankCardCreated(
                bankCard.getId(),
                bankCard.getNumber(),
                bankCard.getCVV()
        );
    }
}
