package com.project.project_web_service_bank_system.adapter.web.controller;

import com.project.project_web_service_bank_system.common.annotation.LogCountRequests;
import com.project.project_web_service_bank_system.domain.dto.request.CreateAccountRequest;
import com.project.project_web_service_bank_system.domain.dto.response.AccountResponse;
import com.project.project_web_service_bank_system.service.AccountService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/*
Контроллер, который получает запрос для регистрации аккаунта
 */

@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequestMapping(value = "/api/bank/client", produces = APPLICATION_JSON_VALUE)
@RestController
public class AccountController {

    AccountService accountService;

    @PostMapping("/register")
    @LogCountRequests
    @Timed(value = "register_account")
    public ResponseEntity<AccountResponse> registerAccount(@RequestBody @Valid CreateAccountRequest accountRequest) {
        return new ResponseEntity<>(accountService.createNewAccount(accountRequest), HttpStatus.OK);
    }
}
