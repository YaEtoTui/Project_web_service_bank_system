package com.project.project_web_service_bank_system.domain.dto.request;

import com.project.project_web_service_bank_system.common.validation.constraint.UsernameConstraint;
import lombok.Value;

@Value
public class CreateAccountRequest {
    @UsernameConstraint
    String username;
    String password;
    String role;
}
