package com.project.project_web_service_bank_system.domain.entity.context;

import lombok.Value;

/*
Context, связочка между сервисом и бд. Так как request крайне не желательно отправлять в бд
 */

@Value
public class AccountContext {
    String username;
    String password;
    String role;
}
