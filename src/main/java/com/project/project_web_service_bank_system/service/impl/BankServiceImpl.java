package com.project.project_web_service_bank_system.service.impl;

import com.project.project_web_service_bank_system.adapter.repository.BankRepository;
import com.project.project_web_service_bank_system.domain.dto.request.CreateBankRequest;
import com.project.project_web_service_bank_system.domain.dto.response.BankResponse;
import com.project.project_web_service_bank_system.domain.entity.Bank;
import com.project.project_web_service_bank_system.domain.entity.context.BankContext;
import com.project.project_web_service_bank_system.service.BankService;
import com.project.project_web_service_bank_system.service.factory.BankFactory;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class BankServiceImpl implements BankService {

    MeterRegistry meterRegistry;
    BankRepository bankRepository;
    BankFactory bankFactory;

    @NonFinal
    Counter counterCountScheduledBank;

    @PostConstruct
    public void init() {
        counterCountScheduledBank = Counter
                .builder("counter.scheduled.count.bank")
                .register(meterRegistry);
    }

    @Override
    public BankResponse addNewBank(CreateBankRequest createRequestBank) {
        BankContext bankContext = bankFactory.createContext(createRequestBank);
        Bank bank = new Bank(bankContext);
        Bank bankEntity = bankRepository.save(bank);
        return bankFactory.createBankResponse(bankEntity);
    }

    @Override
    public List<BankResponse> readAllBank() {
        List<Bank> bank = bankRepository.findAll();
        return bankFactory.createListBankResponse(bank);
    }

    @Async
    @Scheduled(fixedRate = 60000, initialDelay = 100000)
    @SneakyThrows
    public void checkCommand() {
        long startAt = System.currentTimeMillis();
        readAllBank();
        counterCountScheduledBank.increment();
        long time = System.currentTimeMillis() - startAt;
        System.out.printf("Method called: 'readAllBank'. Time: '%s' ms \n", time);
    }
}
