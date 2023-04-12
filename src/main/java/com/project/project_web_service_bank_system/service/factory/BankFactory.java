package com.project.project_web_service_bank_system.service.factory;

import com.project.project_web_service_bank_system.domain.dto.request.CreateBankRequest;
import com.project.project_web_service_bank_system.domain.dto.response.BankResponse;
import com.project.project_web_service_bank_system.domain.entity.Bank;
import com.project.project_web_service_bank_system.domain.entity.context.BankContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BankFactory {
    public BankResponse createBankResponse(Bank bank) {
        return new BankResponse(
                bank.getId(),
                bank.getName()
        );
    }

    public List<BankResponse> createListBankResponse(List<Bank> bankList) {
        return bankList.stream()
                .map(this::createBankResponse)
                .toList();
    }

    public BankContext createContext(CreateBankRequest requestBank) {
        return new BankContext(requestBank.getName());
    }
}
