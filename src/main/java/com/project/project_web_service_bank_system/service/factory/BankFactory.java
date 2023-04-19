package com.project.project_web_service_bank_system.service.factory;

import com.project.project_web_service_bank_system.domain.dto.request.CreateBankRequest;
import com.project.project_web_service_bank_system.domain.dto.response.BankResponse;
import com.project.project_web_service_bank_system.domain.entity.Bank;
import com.project.project_web_service_bank_system.domain.entity.Client;
import com.project.project_web_service_bank_system.domain.entity.context.BankContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BankFactory {
    public BankResponse createBankResponse(Bank bank) {
        return new BankResponse(
                bank.getId(),
                bank.getName(),
                bank.getClients().stream()
                        .map(this::createClientInfo)
                        .collect(Collectors.toList())
        );
    }

    private BankResponse.ClientInfo createClientInfo(Client client) {
        return new BankResponse.ClientInfo(
                client.getId(),
                client.getName(),
                client.getAge()
        );
    }

    public List<BankResponse> createListBankResponse(List<Bank> bankList) {
        return bankList.stream()
                .map(this::createBankResponse)
                .collect(Collectors.toList());
    }

    public BankContext createContext(CreateBankRequest requestBank) {
        return new BankContext(requestBank.getName());
    }
}
