package com.project.project_web_service_bank_system.domain.dto.response;

import lombok.Value;

import java.util.List;

/*
Класс ответа, то есть информацию, которую мы выводим на запрос. Также здесь для списка клиентов будет выводится доп информация
 */

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
