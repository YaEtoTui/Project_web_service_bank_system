package com.project.project_web_service_bank_system.adapter.web.controller;

import com.project.project_web_service_bank_system.adapter.web.annotation.AdminAnnotation;
import com.project.project_web_service_bank_system.domain.dto.request.CreateBankRequest;
import com.project.project_web_service_bank_system.domain.dto.response.BankResponse;
import com.project.project_web_service_bank_system.service.BankService;
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
public class AdminBankController {

    BankService bankService;

    @PostMapping("/bank/new_bank")
    public ResponseEntity<BankResponse> addBank(@RequestBody @Valid CreateBankRequest bankRequest) {
        return new ResponseEntity<>(bankService.addNewBank(bankRequest), HttpStatus.OK);
    }
}
