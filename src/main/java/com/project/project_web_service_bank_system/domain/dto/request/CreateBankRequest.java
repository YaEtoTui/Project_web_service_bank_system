package com.project.project_web_service_bank_system.domain.dto.request;

import com.project.project_web_service_bank_system.common.validation.constraint.NameBankConstraint;
import lombok.Value;

/*
Класс запроса на создание Bank
 */

@Value
public class CreateBankRequest {
    @NameBankConstraint
    String name;
}
