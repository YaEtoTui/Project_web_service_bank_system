package com.project.project_web_service_bank_system.common.exception;

/*
Exception, если не будет найден банк, тут он используется, чтобы искать банк в бд.
То есть мы вызовем ошибку, если не найдем, чтобы потом advice поймал ошибку и в ответ на запрос показал понятный ответ.
 */

public class NotFoundBankException extends RuntimeException {
    public NotFoundBankException(String msg) {
        super(msg);
    }
}
