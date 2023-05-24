package com.project.project_web_service_bank_system.service.impl;

import com.project.project_web_service_bank_system.adapter.repository.AccountRepository;
import com.project.project_web_service_bank_system.domain.dto.request.CreateAccountRequest;
import com.project.project_web_service_bank_system.domain.dto.response.AccountResponse;
import com.project.project_web_service_bank_system.domain.entity.Account;
import com.project.project_web_service_bank_system.domain.entity.context.AccountContext;
import com.project.project_web_service_bank_system.service.AccountService;
import com.project.project_web_service_bank_system.service.factory.AccountFactory;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
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
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class AccountServiceImpl implements AccountService {
    MeterRegistry meterRegistry;
    AccountFactory accountFactory;
    AccountRepository accountRepository;

    @NonFinal
    Counter counterCountScheduled;

    @PostConstruct
    public void init() {
        counterCountScheduled = Counter
                .builder("counter.scheduled.count.account")
                .register(meterRegistry);
    }

    @Override
    public AccountResponse createNewAccount(CreateAccountRequest accountRequest) {
        AccountContext context = accountFactory.createContext(accountRequest);
        Account account = new Account(context);
        account = accountRepository.save(account);
        return accountFactory.createResponse(account);
    }

    @Override
    public List<AccountResponse> readAllAccounts() {
        List<Account> accountList = accountRepository.findAll();
        return accountFactory.createListAccountResponse(accountList);
    }

    @Async
    @Scheduled(fixedRate = 60000, initialDelay = 100000)
    @SneakyThrows
    public void checkCommand() {
        long startAt = System.currentTimeMillis();
        readAllAccounts();
        counterCountScheduled.increment();
        long time = System.currentTimeMillis() - startAt;
        System.out.printf("Method called: 'readAllAccounts'. Time: '%s' ms \n", time);
    }
}
