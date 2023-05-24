package com.project.project_web_service_bank_system.domain.entity;

import com.project.project_web_service_bank_system.domain.entity.context.ClientContext;
import com.project.project_web_service_bank_system.domain.event.NewClientCreated;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/*
Класс который получаем из бд, чтобы потом мы могли с ним работать
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client extends BaseDomainEntity{
    String name;
    Integer age;
    @ManyToOne()
    @JoinColumn(name = "bank_id")
    Bank bank;
    @OneToOne
    @JoinColumn(name = "account_id")
    Account account;
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    List<BankCard> cards = new LinkedList<>();

    public Client(ClientContext clientContext) {
        name = clientContext.getName();
        age = clientContext.getAge();
        bank = clientContext.getBank();
        account = clientContext.getAccount();
        cards = new LinkedList<>();
        registerEvent(() -> NewClientCreated.from(this));
    }
}
