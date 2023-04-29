package com.project.project_web_service_bank_system.adapter.web.controller;

import com.project.project_web_service_bank_system.adapter.web.annotation.UserAnnotation;
import com.project.project_web_service_bank_system.domain.dto.response.BankResponse;
import com.project.project_web_service_bank_system.domain.dto.response.ClientResponse;
import com.project.project_web_service_bank_system.service.BankService;
import com.project.project_web_service_bank_system.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@UserAnnotation
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {
    BankService bankService;
    ClientService clientService;


    @GetMapping("/bank/all")
    public ResponseEntity<List<BankResponse>> readAllBanks() {
        return new ResponseEntity<>(bankService.readAllBank(), HttpStatus.OK);
    }

    @GetMapping("/bank/client/all")
    public ResponseEntity<List<ClientResponse>> readAllClients() {
        return new ResponseEntity<>(clientService.readAllClients(), HttpStatus.OK);
    }
}
