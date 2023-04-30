package com.project.project_web_service_bank_system.domain.dto.response;

import lombok.Value;

import java.util.List;

@Value
public class ClientResponse {
    Long id;
    String name;
    Integer age;
    BankInfo bank;
    AccountInfo account;
    List<BankCardInfo> bankCard;

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

    @Value
    public static class BankCardInfo {
        Long id;
        Long number;
        int CVV;
    }
}
