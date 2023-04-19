package com.project.project_web_service_bank_system.domain.dto.response;

import lombok.Value;

import java.util.List;

@Value
public class BankResponse {
    Long id;
    String name;
    List<ClientInfo> clients;

    @Value
    public static class ClientInfo {
        Long id;
        String name;
        Integer age;
    }
}
