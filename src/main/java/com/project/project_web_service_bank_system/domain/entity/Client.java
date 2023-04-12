package com.project.project_web_service_bank_system.domain.entity;

import com.project.project_web_service_bank_system.domain.entity.context.ClientContext;
import jakarta.persistence.*;
import lombok.*;


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

    public static Client createClient(ClientContext context) {
        return Client.builder()
                .name(context.getName())
                .age(context.getAge())
                .build();
    }

    public int hashCode() {
        return id.hashCode();
    }
}
