package com.project.project_web_service_bank_system.domain.entity;

import com.project.project_web_service_bank_system.domain.entity.context.AccountContext;
import com.project.project_web_service_bank_system.domain.event.NewAccountCreated;
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
@Table(name = "account")
public class Account extends BaseDomainEntity{
    String username;
    String password;
    String role;
    Boolean enabled;

    public Account(AccountContext accountContext) {
        username = accountContext.getUsername();
        password = accountContext.getPassword();
        role = accountContext.getRole();
        enabled = true;
        registerEvent(() -> NewAccountCreated.from(this));
    }
}
