package com.project.project_web_service_bank_system.adapter.web.controller;

import com.project.project_web_service_bank_system.adapter.web.annotation.PublicAnnotation;
import com.project.project_web_service_bank_system.domain.dto.response.ClientResponse;
import com.project.project_web_service_bank_system.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@PublicAnnotation
public class ClientController {
    ClientService clientService;

    @GetMapping("/bank/client/all")
    public ResponseEntity<List<ClientResponse>> readAll() {
        return new ResponseEntity<>(clientService.readAllClients(), HttpStatus.OK);
    }
}
