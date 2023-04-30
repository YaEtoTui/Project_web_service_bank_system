package com.project.project_web_service_bank_system.service.factory;

import com.project.project_web_service_bank_system.adapter.repository.AccountRepository;
import com.project.project_web_service_bank_system.adapter.repository.BankRepository;
import com.project.project_web_service_bank_system.common.exception.NotFoundAccountException;
import com.project.project_web_service_bank_system.common.exception.NotFoundBankException;
import com.project.project_web_service_bank_system.domain.dto.request.CreateClientRequest;
import com.project.project_web_service_bank_system.domain.dto.response.ClientResponse;
import com.project.project_web_service_bank_system.domain.entity.Account;
import com.project.project_web_service_bank_system.domain.entity.Bank;
import com.project.project_web_service_bank_system.domain.entity.BankCard;
import com.project.project_web_service_bank_system.domain.entity.Client;
import com.project.project_web_service_bank_system.domain.entity.context.ClientContext;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ClientFactory {
    BankRepository bankRepository;
    AccountRepository accountRepository;

    public ClientResponse createClientResponse(Client client) {
        return new ClientResponse(
                client.getId(),
                client.getName(),
                client.getAge(),
                createBankInfo(client.getBank()),
                createAccountInfo(client.getAccount()),
                client.getCards().stream()
                        .map(this::createBankCardInfo)
                        .collect(Collectors.toList())
        );
    }

    private ClientResponse.AccountInfo createAccountInfo(Account account) {
        return new ClientResponse.AccountInfo(
                account.getId(),
                account.getUsername(),
                account.getRole()
        );
    }

    private ClientResponse.BankInfo createBankInfo(Bank bank) {
        return new ClientResponse.BankInfo(
                bank.getId(),
                bank.getName()
        );
    }

    private ClientResponse.BankCardInfo createBankCardInfo(BankCard bankCard) {
        return new ClientResponse.BankCardInfo(
                bankCard.getId(),
                bankCard.getNumber(),
                bankCard.getCVV()
        );
    }

    public List<ClientResponse> createListClientResponse(List<Client> clientList) {
        return clientList.stream()
                .map(this::createClientResponse)
                .collect(Collectors.toList());
    }

    public ClientContext createContext(CreateClientRequest requestClient) {
        Bank bank = bankRepository.findById(requestClient.getBankId())
                .orElseThrow(() -> new NotFoundBankException(
                        String.format("Not found bank with id: %d", requestClient.getBankId())
                        )
                );

        Account account = accountRepository.findById(requestClient.getAccountId())
                .orElseThrow(() -> new NotFoundAccountException(
                        String.format("Not found account with id: %d", requestClient.getAccountId())
                        )
                );

        return new ClientContext(
                requestClient.getName(),
                requestClient.getAge(),
                bank,
                account
        );
    }
}
