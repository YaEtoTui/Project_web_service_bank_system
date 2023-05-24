package com.project.project_web_service_bank_system.adapter.web.controller;

import com.project.project_web_service_bank_system.adapter.web.annotation.UserAnnotation;
import com.project.project_web_service_bank_system.common.annotation.LogCountRequests;
import com.project.project_web_service_bank_system.domain.dto.response.BankCardResponse;
import com.project.project_web_service_bank_system.service.BankCardService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;


import static lombok.AccessLevel.PRIVATE;

/*
Контроллер, который получает запрос с аккаунтов с ролью user или admin(но предпочительней user).
Например, создать карту себе(клиенту).
 */

@UserAnnotation
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {
    BankCardService bankCardService;

    @PostMapping("/bank/client/bankCard")
    @LogCountRequests
    @Timed("add_bank_card")
    public ResponseEntity<BankCardResponse> addBankCard() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return new ResponseEntity<>(bankCardService.createBankCard(authentication.getName()), HttpStatus.OK);
    }
}
