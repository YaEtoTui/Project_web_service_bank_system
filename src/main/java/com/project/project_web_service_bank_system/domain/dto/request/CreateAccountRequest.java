package com.project.project_web_service_bank_system.domain.dto.request;

import com.project.project_web_service_bank_system.common.validation.constraint.RoleConstraint;
import com.project.project_web_service_bank_system.common.validation.constraint.UsernameConstraint;
import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class CreateAccountRequest {
    @UsernameConstraint
    String username;
    @NotBlank
    String password;
    @RoleConstraint
    String role;
}
