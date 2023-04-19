package com.project.project_web_service_bank_system.domain.entity.context;

import com.project.project_web_service_bank_system.domain.entity.Bank;
import lombok.Value;

@Value
public class ClientContext {
    String name;
    Integer age;
    Bank bank;
}
