package com.project.project_web_service_bank_system.domain.dto.request;

import com.project.project_web_service_bank_system.common.validation.constraint.RoleAccountConstraint;
import com.project.project_web_service_bank_system.common.validation.constraint.UsernameAccountConstraint;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class CreateAccountRequest {
    @UsernameAccountConstraint
    String username;
    @NotBlank
    String password;
    @RoleAccountConstraint
    String role;
}
