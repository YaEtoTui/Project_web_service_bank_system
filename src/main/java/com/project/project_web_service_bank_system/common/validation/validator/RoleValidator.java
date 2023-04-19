package com.project.project_web_service_bank_system.common.validation.validator;

import com.project.project_web_service_bank_system.common.validation.constraint.RoleConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class RoleValidator implements ConstraintValidator<RoleConstraint, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (value.equals("ROLE_ADMIN") || value.equals("ROLE_USER"));
    }
}
