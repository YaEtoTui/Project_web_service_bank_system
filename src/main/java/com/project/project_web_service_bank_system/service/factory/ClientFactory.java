package com.project.project_web_service_bank_system.service.factory;

import com.project.project_web_service_bank_system.adapter.repository.BankRepository;
import com.project.project_web_service_bank_system.common.exception.NotFoundException;
import com.project.project_web_service_bank_system.domain.dto.request.CreateClientRequest;
import com.project.project_web_service_bank_system.domain.dto.response.ClientResponse;
import com.project.project_web_service_bank_system.domain.entity.Bank;
import com.project.project_web_service_bank_system.domain.entity.Client;
import com.project.project_web_service_bank_system.domain.entity.context.ClientContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ClientFactory {
    BankRepository bankRepository;

    public ClientResponse createClientResponse(Client client) {
        return new ClientResponse(
                client.getId(),
                client.getName(),
                client.getAge(),
                createBankInfo(client.getBank())
        );
    }

    private ClientResponse.BankInfo createBankInfo(Bank bank) {
        return new ClientResponse.BankInfo(
                bank.getId(),
                bank.getName()
        );
    }

    public List<ClientResponse> createListClientResponse(List<Client> clientList) {
        return clientList.stream()
                .map(this::createClientResponse)
                .collect(Collectors.toList());
    }

    public ClientContext createContext(CreateClientRequest requestClient) {
        Bank bank = bankRepository.findById(requestClient.getBankId())
                .orElseThrow(() -> new NotFoundException(
                        String.format("Not found bank with id %d", requestClient.getBankId())
                        )
                );
        return new ClientContext(
                requestClient.getName(),
                requestClient.getAge(),
                bank
        );
    }
}
