package com.project.project_web_service_bank_system.common.validation.constraint;


import com.project.project_web_service_bank_system.common.validation.validator.RoleAccountValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

/*
Аннотация нужна чтобы сделать валидацию поля role класса Account
 */

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD})
@Constraint(validatedBy = RoleAccountValidator.class)
@NotBlank
public @interface RoleAccountConstraint {
    String message() default "wrong role written(ROLE_USER, ROLE_ADMIN)";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
