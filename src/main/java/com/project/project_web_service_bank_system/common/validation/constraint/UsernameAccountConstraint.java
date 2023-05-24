package com.project.project_web_service_bank_system.common.validation.constraint;

import com.project.project_web_service_bank_system.common.validation.validator.UsernameAccountValidator;

import javax.validation.*;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

/*
Аннотация нужна чтобы сделать валидацию поля username класса Account
 */

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD})
@Constraint(validatedBy = UsernameAccountValidator.class)
@NotBlank
public @interface UsernameAccountConstraint {
    String message() default "username already exists";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
