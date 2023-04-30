package com.project.project_web_service_bank_system.service.factory;

import com.project.project_web_service_bank_system.adapter.repository.ClientRepository;
import com.project.project_web_service_bank_system.common.exception.NotFoundClientEception;
import com.project.project_web_service_bank_system.domain.dto.request.CreateBankCardRequest;
import com.project.project_web_service_bank_system.domain.dto.response.BankCardResponse;
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
    public BankCardContext createBankCardContext(CreateBankCardRequest bankCardRequest) {
        Client client = clientRepository.findById(bankCardRequest.getClientId())
                .orElseThrow(() -> new NotFoundClientEception(
                                String.format("Not found client with id: %d", bankCardRequest.getClientId())
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
}
