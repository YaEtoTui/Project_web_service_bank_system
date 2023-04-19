package com.project.project_web_service_bank_system.service.impl;

import com.project.project_web_service_bank_system.adapter.repository.AccountRepository;
import com.project.project_web_service_bank_system.domain.dto.request.CreateAccountRequest;
import com.project.project_web_service_bank_system.domain.dto.response.AccountResponse;
import com.project.project_web_service_bank_system.domain.entity.Account;
import com.project.project_web_service_bank_system.domain.entity.context.AccountContext;
import com.project.project_web_service_bank_system.service.AccountService;
import com.project.project_web_service_bank_system.service.factory.AccountFactory;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static lombok.AccessLevel.PRIVATE;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class AccountServiceImpl implements AccountService {
    AccountFactory accountFactory;
    AccountRepository accountRepository;

    @Override
    public AccountResponse createNewAccount(CreateAccountRequest accountRequest) {
        AccountContext context = accountFactory.createContext(accountRequest);
        Account account = Account.createAccountFrom(context);
        account = accountRepository.save(account);
        return accountFactory.createResponse(account);
    }
}
