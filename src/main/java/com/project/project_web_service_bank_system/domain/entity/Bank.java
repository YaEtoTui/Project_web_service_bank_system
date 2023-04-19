package com.project.project_web_service_bank_system.domain.entity;

import com.project.project_web_service_bank_system.domain.entity.context.BankContext;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    Long id;
    String name;
    @OneToMany(mappedBy = "bank", fetch = FetchType.LAZY)
    List<Client> clients = new LinkedList<>();

    public static Bank createBank(BankContext bankContext) {
        return Bank.builder()
                .name(bankContext.getName())
                .clients(new LinkedList<>())
                .build();
    }
}
