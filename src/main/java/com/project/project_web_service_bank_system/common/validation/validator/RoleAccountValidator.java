package com.project.project_web_service_bank_system.common.validation.validator;

import com.project.project_web_service_bank_system.common.validation.constraint.RoleAccountConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/*
Валидатор, в котором прописываем условия валидации поля role класса Account
 */

public class RoleAccountValidator implements ConstraintValidator<RoleAccountConstraint, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (value.equals("ROLE_ADMIN") || value.equals("ROLE_USER"));
    }
}
