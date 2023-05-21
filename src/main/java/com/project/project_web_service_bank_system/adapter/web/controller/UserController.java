package com.project.project_web_service_bank_system.adapter.web.controller;

import com.project.project_web_service_bank_system.adapter.web.annotation.UserAnnotation;
import com.project.project_web_service_bank_system.common.annotation.LogCountRequests;
import com.project.project_web_service_bank_system.domain.dto.request.CreateBankCardRequest;
import com.project.project_web_service_bank_system.domain.dto.response.BankCardResponse;
import com.project.project_web_service_bank_system.service.BankCardService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import static lombok.AccessLevel.PRIVATE;

@UserAnnotation
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {
    BankCardService bankCardService;

    @PostMapping("/bank/client/bankCard")
    @LogCountRequests
    public ResponseEntity<BankCardResponse> addBankCard(@RequestBody CreateBankCardRequest cardRequest) {
        return new ResponseEntity<>(bankCardService.createBankCard(cardRequest), HttpStatus.OK);
    }
}
