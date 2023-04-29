package com.project.project_web_service_bank_system.common.exception;

public class NotFoundAccountException extends RuntimeException {
    public NotFoundAccountException(String msg) {
        super(msg);
    }
}
