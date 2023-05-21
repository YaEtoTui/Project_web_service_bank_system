package com.project.project_web_service_bank_system.service.impl;

import com.project.project_web_service_bank_system.adapter.repository.BankCardRepository;
import com.project.project_web_service_bank_system.domain.dto.response.BankCardResponse;
import com.project.project_web_service_bank_system.domain.entity.BankCard;
import com.project.project_web_service_bank_system.domain.entity.context.BankCardContext;
import com.project.project_web_service_bank_system.service.BankCardService;
import com.project.project_web_service_bank_system.service.factory.BankCardFactory;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static lombok.AccessLevel.PRIVATE;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Builder
public class BankCardServiceImpl implements BankCardService {
    BankCardRepository bankCardRepository;
    BankCardFactory bankCardFactory;

    @Override
    public BankCardResponse createBankCard(String nameAccount) {
        Long clientId = bankCardFactory.searchClientId(nameAccount);
        BankCardContext cardContext = bankCardFactory.createBankCardContext(clientId);
        BankCard bankCard = new BankCard(cardContext);
        BankCard bankCardEntity = bankCardRepository.save(bankCard);
        return bankCardFactory.createBankCardResponse(bankCardEntity);
    }
}
