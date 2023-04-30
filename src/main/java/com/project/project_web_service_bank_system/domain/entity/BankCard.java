package com.project.project_web_service_bank_system.domain.entity;

import com.project.project_web_service_bank_system.domain.entity.context.BankCardContext;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bank_card")
public class BankCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    Long id;
    Long number;
    int CVV;
    @ManyToOne()
    @JoinColumn(name = "client_id")
    Client client;

    public static BankCard createBankCard(BankCardContext bankCardContext) {
        return BankCard.builder()
                .number((int) (Math.random() * ((max - min) + 1 )) + min)
                .CVV((int) (Math.random() * ((999 - 100) + 1 )) + 100)
                .client(bankCardContext.getClient())
                .build();
    }

    static long max = 999999999;
    static long min = 100000000;
}
