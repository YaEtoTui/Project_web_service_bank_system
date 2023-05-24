package com.project.project_web_service_bank_system.adapter.web.controller;

import com.project.project_web_service_bank_system.adapter.web.annotation.AdminAnnotation;
import com.project.project_web_service_bank_system.common.annotation.LogCountRequests;
import com.project.project_web_service_bank_system.domain.dto.request.CreateBankRequest;
import com.project.project_web_service_bank_system.domain.dto.request.CreateClientRequest;
import com.project.project_web_service_bank_system.domain.dto.response.AccountResponse;
import com.project.project_web_service_bank_system.domain.dto.response.BankResponse;
import com.project.project_web_service_bank_system.domain.dto.response.ClientResponse;
import com.project.project_web_service_bank_system.service.AccountService;
import com.project.project_web_service_bank_system.service.BankService;
import com.project.project_web_service_bank_system.service.ClientService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

/*
Контроллер, который пишет аккаунт с ролью 'ROLE_ADMIN'. Например, Добавить банк, клиента
или посмотреть список банков, клиентов, аккаунтов
 */

@FieldDefaults(level = PRIVATE, makeFinal = true)
@AdminAnnotation
@RequiredArgsConstructor
public class AdminController {
    BankService bankService;
    ClientService clientService;
    AccountService accountService;


    @PostMapping("/bank/new_bank")
    @LogCountRequests
    @Timed("add_bank")
    @CacheEvict(value = "cache_read", allEntries = true)
    public ResponseEntity<BankResponse> addBank(@RequestBody @Valid CreateBankRequest bankRequest) {
        return new ResponseEntity<>(bankService.addNewBank(bankRequest), HttpStatus.OK);
    }

    @PostMapping("/bank/new_client")
    @LogCountRequests
    @Timed("add_client")
    @CacheEvict(value = "cache_read", allEntries = true)
    public ResponseEntity<ClientResponse> addClient(@RequestBody @Valid CreateClientRequest clientRequest) {
        return new ResponseEntity<>(clientService.addNewClient(clientRequest), HttpStatus.OK);
    }

    @GetMapping("/bank/all")
    @LogCountRequests
    @Timed("read_all_banks")
    @Cacheable("cache_read")
    public ResponseEntity<List<BankResponse>> readAllBanks() {
        return new ResponseEntity<>(bankService.readAllBank(), HttpStatus.OK);
    }

    @GetMapping("/bank/client/all")
    @LogCountRequests
    @Timed("read_all_clients")
    public ResponseEntity<List<ClientResponse>> readAllClients() {
        return new ResponseEntity<>(clientService.readAllClients(), HttpStatus.OK);
    }

    @GetMapping("/bank/account/all")
    @LogCountRequests
    @Timed("read_all_accounts")
    public ResponseEntity<List<AccountResponse>> readAllAccounts() {
        return new ResponseEntity<>(accountService.readAllAccounts(), HttpStatus.OK);
    }
}
