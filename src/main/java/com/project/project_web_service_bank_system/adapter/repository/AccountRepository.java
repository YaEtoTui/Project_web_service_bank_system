package com.project.project_web_service_bank_system.adapter.repository;

import com.project.project_web_service_bank_system.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Репозиторий, связочка с сервером и бд(Account), помогает сохранять информацию в бд и получать ее оттуда
 */

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByUsername(String username);
    Account findAccountByUsername(String username);
}
