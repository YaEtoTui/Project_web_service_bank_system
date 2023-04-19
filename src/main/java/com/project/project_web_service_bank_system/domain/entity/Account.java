package com.project.project_web_service_bank_system.domain.entity;

import com.project.project_web_service_bank_system.domain.entity.context.AccountContext;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    Long id;

    String username;

    String password;

    String role;

    Boolean ban;

    public static Account createAccountFrom(AccountContext context) {
        return Account.builder()
                .username(context.getUsername())
                .password(context.getPassword())
                .role(context.getRole())
                .ban(true)
                .build();
    }
}
