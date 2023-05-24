package com.project.project_web_service_bank_system.adapter.web.advice;

import com.project.project_web_service_bank_system.common.exception.NotFoundAccountException;
import com.project.project_web_service_bank_system.common.exception.NotFoundBankException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

/*
Advice который ловит ошибки, если не найден банк или аккаунт
 */

@RestControllerAdvice
@RequiredArgsConstructor
public class NotFoundAdvice {

    @ExceptionHandler({NotFoundBankException.class, NotFoundAccountException.class})
    public ResponseEntity<String> notFound(Exception e) {
        return status(NOT_FOUND)
                .body(e.getMessage());
    }
}
