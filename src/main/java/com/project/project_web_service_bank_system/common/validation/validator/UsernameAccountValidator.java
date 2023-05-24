package com.project.project_web_service_bank_system.common.validation.validator;

import com.project.project_web_service_bank_system.adapter.repository.AccountRepository;
import com.project.project_web_service_bank_system.common.validation.constraint.UsernameAccountConstraint;
import com.project.project_web_service_bank_system.domain.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/*
Валидатор, в котором прописываем условия валидации поля username класса Account
 */

public class UsernameAccountValidator implements ConstraintValidator<UsernameAccountConstraint, String> {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<Account> accountList = accountRepository.findAllByUsername(value);
        return accountList.isEmpty();
    }
}
