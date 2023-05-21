package com.project.project_web_service_bank_system.adapter.web.controller;

import com.project.project_web_service_bank_system.adapter.web.annotation.UserAnnotation;
import com.project.project_web_service_bank_system.common.annotation.LogCountRequests;
import com.project.project_web_service_bank_system.domain.dto.request.CreateAccountRequest;
import com.project.project_web_service_bank_system.domain.dto.response.AccountResponse;
import com.project.project_web_service_bank_system.domain.dto.response.BankResponse;
import com.project.project_web_service_bank_system.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequestMapping(value = "/api/bank/client", produces = APPLICATION_JSON_VALUE)
@RestController
public class AccountController {

    AccountService accountService;

    @PostMapping("/register")
    @LogCountRequests
    public ResponseEntity<AccountResponse> registerAccount(@RequestBody @Valid CreateAccountRequest accountRequest) {
        return new ResponseEntity<>(accountService.createNewAccount(accountRequest), HttpStatus.OK);
    }
}
