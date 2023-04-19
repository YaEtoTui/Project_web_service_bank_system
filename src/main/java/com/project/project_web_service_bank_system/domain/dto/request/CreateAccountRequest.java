package com.project.project_web_service_bank_system.domain.dto.request;

import lombok.Value;

@Value
public class CreateAccountRequest {
    String username;
    String password;
    String role;
}
