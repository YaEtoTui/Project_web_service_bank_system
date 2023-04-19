package com.project.project_web_service_bank_system.service;

import com.project.project_web_service_bank_system.domain.dto.request.CreateAccountRequest;
import com.project.project_web_service_bank_system.domain.dto.response.AccountResponse;

public interface AccountService {
    AccountResponse createNewAccount(CreateAccountRequest accountRequest);
}
