package com.project.project_web_service_bank_system.domain.entity;

import com.project.project_web_service_bank_system.domain.entity.context.ClientContext;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 1)
    Long id;
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

    public static Client createClient(ClientContext context) {
        return Client.builder()
                .name(context.getName())
                .age(context.getAge())
                .bank(context.getBank())
                .account(context.getAccount())
                .cards(new LinkedList<>())
                .build();
    }
}
