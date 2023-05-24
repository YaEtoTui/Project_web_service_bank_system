package com.project.project_web_service_bank_system.common.validation.validator;

import com.project.project_web_service_bank_system.adapter.repository.BankRepository;
import com.project.project_web_service_bank_system.common.validation.constraint.NameBankConstraint;
import com.project.project_web_service_bank_system.domain.entity.Bank;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/*
Валидатор, в котором прописываем условия валидации поля name класса Bank
 */

public class NameBankValidator implements ConstraintValidator<NameBankConstraint, String> {
    @Autowired
    BankRepository bankRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<Bank> bankList = bankRepository.findAllByName(value);
        return bankList.isEmpty();
    }
}
