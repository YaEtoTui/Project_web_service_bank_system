package com.project.project_web_service_bank_system.domain.entity;

import com.project.project_web_service_bank_system.domain.entity.context.BankContext;
import com.project.project_web_service_bank_system.domain.event.NewBankCreated;
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
@Table(name = "bank")
public class Bank extends BaseDomainEntity{
    String name;
    @OneToMany(mappedBy = "bank", fetch = FetchType.LAZY)
    List<Client> clients = new LinkedList<>();

    public Bank(BankContext bankContext) {
        name = bankContext.getName();
        clients = new LinkedList<>();
        registerEvent(() -> NewBankCreated.from(this));
    }
}
