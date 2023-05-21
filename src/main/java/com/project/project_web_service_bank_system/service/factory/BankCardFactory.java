package com.project.project_web_service_bank_system.service.factory;

import com.project.project_web_service_bank_system.adapter.repository.AccountRepository;
import com.project.project_web_service_bank_system.adapter.repository.ClientRepository;
import com.project.project_web_service_bank_system.common.exception.NotFoundClientEception;
import com.project.project_web_service_bank_system.domain.dto.response.BankCardResponse;
import com.project.project_web_service_bank_system.domain.entity.Account;
import com.project.project_web_service_bank_system.domain.entity.BankCard;
import com.project.project_web_service_bank_system.domain.entity.Client;
import com.project.project_web_service_bank_system.domain.entity.context.BankCardContext;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class BankCardFactory {
    ClientRepository clientRepository;
    AccountRepository accountRepository;

    public BankCardContext createBankCardContext(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundClientEception(
                                String.format("Not found client with id: %d", clientId)
                        )
                );
        return new BankCardContext(
                client
        );
    }

    public BankCardResponse createBankCardResponse(BankCard bankCard) {
        return new BankCardResponse(
                bankCard.getId(),
                bankCard.getNumber(),
                bankCard.getCVV()
        );
    }

    public Long searchClientId(String nameAccount) {
        Account account = accountRepository.findAccountByUsername(nameAccount);
        Client client = clientRepository.findClientByAccountId(account.getId());
        return client.getId();
    }
}
