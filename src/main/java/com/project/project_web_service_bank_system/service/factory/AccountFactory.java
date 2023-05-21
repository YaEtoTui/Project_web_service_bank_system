package com.project.project_web_service_bank_system.service.factory;

import com.project.project_web_service_bank_system.domain.dto.request.CreateAccountRequest;
import com.project.project_web_service_bank_system.domain.dto.response.AccountResponse;
import com.project.project_web_service_bank_system.domain.entity.Account;
import com.project.project_web_service_bank_system.domain.entity.context.AccountContext;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;


@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class AccountFactory {
    PasswordEncoder passwordEncoder;

    public AccountResponse createResponse(Account account) {
        return new AccountResponse(
                account.getUsername(),
                account.getRole()
        );
    }

    public AccountContext createContext(CreateAccountRequest createAccountRequest) {
        return new AccountContext(
                createAccountRequest.getUsername(),
                passwordEncoder.encode(createAccountRequest.getPassword()),
                createAccountRequest.getRole()
        );
    }

    public List<AccountResponse> createListAccountResponse(List<Account> accountList) {
        return accountList.stream()
                .map(this::createResponse)
                .collect(Collectors.toList());
    }
}
