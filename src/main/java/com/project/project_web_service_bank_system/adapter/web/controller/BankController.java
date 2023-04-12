package com.project.project_web_service_bank_system.adapter.web.controller;

import com.project.project_web_service_bank_system.adapter.web.annotation.ClientAnnotation;
import com.project.project_web_service_bank_system.domain.dto.response.BankResponse;
import com.project.project_web_service_bank_system.service.impl.BankServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@ClientAnnotation
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class BankController {

    BankServiceImpl bankService;

    @GetMapping("/bank/all")
    public ResponseEntity<List<BankResponse>> readAll() {
        return new ResponseEntity<>(bankService.readAllBank(), HttpStatus.OK);
    }
}
