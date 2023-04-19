package com.project.project_web_service_bank_system.common.validation.constraint;


import com.project.project_web_service_bank_system.common.validation.validator.RoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD})
@Constraint(validatedBy = RoleValidator.class)
@NotBlank
public @interface RoleConstraint {
    String message() default "wrong role written(ROLE_USER, ROLE_ADMIN)";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
