package com.project.project_web_service_bank_system.adapter.web.advice;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

/*
Advice который ловит ошибки, если аргумент, введенный в Body, окажется не валидный, то есть не удовлетворяет условиям,
которые мы прописали в валидаторе(это если мы сами ручками пишем)
или который не удовлетворяет условиям аннотациям валидатор(по умолчанию данные)
 */

@ControllerAdvice
public class NotValidAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
    }
}
