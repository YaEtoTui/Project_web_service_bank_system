package com.project.project_web_service_bank_system.common.exception;

/*
Exception, если не будет найден клиент, тут он используется, чтобы искать клиента в бд.
То есть мы вызовем ошибку, если не найдем, чтобы потом advice поймал ошибку и в ответ на запрос показал понятный ответ.
 */

public class NotFoundClientEception extends RuntimeException{
    public NotFoundClientEception(String msg) {
        super(msg);
    }
}
