package com.project.project_web_service_bank_system.domain.dto.request;

import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
Класс запроса на создание Client
 */

@Value
public class CreateClientRequest {
    @NotBlank
    String name;
    @NotNull
    @Min(value = 18, message = "Минимальный возраст 18 лет")
    Integer age;
    Long bankId;
    Long accountId;
}
