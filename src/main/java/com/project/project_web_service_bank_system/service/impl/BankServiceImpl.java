package com.project.project_web_service_bank_system.service.impl;

import com.project.project_web_service_bank_system.adapter.repository.BankRepository;
import com.project.project_web_service_bank_system.domain.dto.request.CreateBankRequest;
import com.project.project_web_service_bank_system.domain.dto.response.BankResponse;
import com.project.project_web_service_bank_system.domain.entity.Bank;
import com.project.project_web_service_bank_system.domain.entity.context.BankContext;
import com.project.project_web_service_bank_system.service.BankService;
import com.project.project_web_service_bank_system.service.factory.BankFactory;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@Builder
public class BankServiceImpl implements BankService {

    BankRepository bankRepository;
    BankFactory bankFactory;

    @Override
    public BankResponse addNewBank(CreateBankRequest createRequestBank) {
        BankContext bankContext = bankFactory.createContext(createRequestBank);
        Bank bank = Bank.createBank(bankContext);
        Bank bankEntity = bankRepository.save(bank);
        return bankFactory.createBankResponse(bankEntity);
    }

    @Override
    public List<BankResponse> readAllBank() {
        List<Bank> bank = bankRepository.findAll();
        return bankFactory.createListBankResponse(bank);
    }
}
