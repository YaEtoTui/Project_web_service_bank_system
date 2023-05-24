package com.project.project_web_service_bank_system.common.exception;

/*
Exception, если не будет найден аккаунт, тут он используется, чтобы искать аккаунт в бд.
То есть мы вызовем ошибку, если не найдем, чтобы потом advice поймал ошибку и в ответ на запрос показал понятный ответ.
 */

public class NotFoundAccountException extends RuntimeException {
    public NotFoundAccountException(String msg) {
        super(msg);
    }
}
