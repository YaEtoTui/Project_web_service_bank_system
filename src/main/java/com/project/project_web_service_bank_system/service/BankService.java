package com.project.project_web_service_bank_system.service;

import com.project.project_web_service_bank_system.domain.dto.request.CreateBankRequest;
import com.project.project_web_service_bank_system.domain.dto.response.BankResponse;

import java.util.List;

public interface BankService {
    BankResponse addNewBank(CreateBankRequest createRequestBank);
    List<BankResponse> readAllBank();
}
