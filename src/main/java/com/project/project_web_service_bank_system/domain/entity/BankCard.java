package com.project.project_web_service_bank_system.domain.entity;

import com.project.project_web_service_bank_system.domain.entity.context.BankCardContext;
import com.project.project_web_service_bank_system.domain.event.NewBankCardCreated;
import lombok.*;

import javax.persistence.*;

/*
Класс который получаем из бд, чтобы потом мы могли с ним работать
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bank_card")
public class BankCard extends BaseDomainEntity{
    Long number;
    int CVV;
    @ManyToOne()
    @JoinColumn(name = "client_id")
    Client client;

    public BankCard(BankCardContext bankCardContext) {
        number = (int) (Math.random() * ((max - min) + 1 )) + min;
        CVV = (int) (Math.random() * ((999 - 100) + 1 )) + 100;
        client = bankCardContext.getClient();
        registerEvent(() -> NewBankCardCreated.from(this));
    }

    static long max = 999999999;
    static long min = 100000000;
}
