package com.project.project_web_service_bank_system.domain.dto.response;

import lombok.Value;

/*
Класс ответа, то есть информацию, которую мы выводим на запрос
 */

@Value
public class BankCardResponse {
    Long id;
    Long number;
    int CVV;
}
