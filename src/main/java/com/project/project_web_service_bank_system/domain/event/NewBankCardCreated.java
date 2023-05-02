package com.project.project_web_service_bank_system.domain.event;

import com.project.project_web_service_bank_system.domain.entity.BankCard;
import lombok.Value;

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
