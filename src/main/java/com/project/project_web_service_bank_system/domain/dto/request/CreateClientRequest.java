package com.project.project_web_service_bank_system.domain.dto.request;

import lombok.Value;

@Value
public class CreateClientRequest {
    String name;
    Integer age;
    Long bankId;
}
