package com.project.project_web_service_bank_system.service;

import com.project.project_web_service_bank_system.domain.dto.response.BankCardResponse;

public interface BankCardService {
    BankCardResponse createBankCard(String nameAccount);
}
