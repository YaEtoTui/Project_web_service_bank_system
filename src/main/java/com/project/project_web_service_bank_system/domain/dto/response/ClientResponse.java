package com.project.project_web_service_bank_system.domain.dto.response;

import lombok.Value;

@Value
public class ClientResponse {
    Long id;
    String name;
    Integer age;
    BankInfo bank;
    AccountInfo account;

    @Value
    public static class BankInfo {
        Long id;
        String name;
    }

    @Value
    public static class AccountInfo {
        Long id;
        String username;
        String role;
    }
}
