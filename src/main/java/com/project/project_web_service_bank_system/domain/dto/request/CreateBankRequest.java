package com.project.project_web_service_bank_system.domain.dto.request;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class CreateBankRequest {
    @NotBlank
    String name;
}
