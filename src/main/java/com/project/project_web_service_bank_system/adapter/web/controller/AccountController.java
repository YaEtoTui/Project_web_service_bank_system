package com.project.project_web_service_bank_system.adapter.web.controller;

import com.project.project_web_service_bank_system.adapter.web.annotation.PublicAnnotation;
import com.project.project_web_service_bank_system.domain.dto.request.CreateAccountRequest;
import com.project.project_web_service_bank_system.domain.dto.response.AccountResponse;
import com.project.project_web_service_bank_system.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static lombok.AccessLevel.PRIVATE;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@PublicAnnotation
public class AccountController {

    AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<AccountResponse> createProduct(@RequestBody CreateAccountRequest accountRequest) {
        return new ResponseEntity<>(accountService.createNewAccount(accountRequest), HttpStatus.OK);
    }
}
