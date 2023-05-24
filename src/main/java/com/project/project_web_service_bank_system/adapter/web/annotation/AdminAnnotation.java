package com.project.project_web_service_bank_system.adapter.web.annotation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/*
Аннотация для контроллеров, которыми может пользоваться account с ролью 'ROLE_ADMIN'
 */

@Documented
@RestController
@RequestMapping(value = "/admin/api", produces = APPLICATION_JSON_VALUE)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminAnnotation {
}
