package com.project.project_web_service_bank_system.common.validation.constraint;

import com.project.project_web_service_bank_system.common.validation.validator.NameBankValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

/*
Аннотация нужна чтобы сделать валидацию поля name класса Bank
 */

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD})
@Constraint(validatedBy = NameBankValidator.class)
@NotBlank
public @interface NameBankConstraint {
    String message() default "the name of the bank is already such a name";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
