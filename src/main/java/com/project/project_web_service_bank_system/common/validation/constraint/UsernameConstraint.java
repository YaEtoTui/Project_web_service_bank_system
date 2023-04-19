package com.project.project_web_service_bank_system.common.validation.constraint;

import com.project.project_web_service_bank_system.common.validation.validator.UsernameValidator;

import javax.validation.*;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD})
@Constraint(validatedBy = UsernameValidator.class)
@NotBlank
public @interface UsernameConstraint {
    String message() default "username already exists";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
