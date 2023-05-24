package com.project.project_web_service_bank_system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/*
Включаем Async для джобов и events(чтобы выполнялось параллельно)
 */

@Configuration
@EnableAsync
public class AsyncConfig {
}
