package com.project.project_web_service_bank_system.adapter.web.controller;

import com.project.project_web_service_bank_system.adapter.web.annotation.AdminAnnotation;
import com.project.project_web_service_bank_system.domain.dto.request.CreateClientRequest;
import com.project.project_web_service_bank_system.domain.dto.response.ClientResponse;
import com.project.project_web_service_bank_system.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@AdminAnnotation
@RequiredArgsConstructor
public class AdminClientController {

    ClientService clientService;

    @PostMapping("/bank/new_client")
    public ResponseEntity<ClientResponse> addClient(@RequestBody @Valid CreateClientRequest clientRequest) {
        return new ResponseEntity<>(clientService.addNewClient(clientRequest), HttpStatus.OK);
    }

}
