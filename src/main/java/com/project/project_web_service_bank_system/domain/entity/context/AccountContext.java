package com.project.project_web_service_bank_system.domain.entity.context;

import lombok.Value;

@Value
public class AccountContext {
    String username;
    String password;
    String role;
}
