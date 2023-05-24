package com.project.project_web_service_bank_system.adapter.repository;

import com.project.project_web_service_bank_system.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Репозиторий, связочка с сервером и бд(Client), помогает сохранять информацию в бд и получать ее оттуда
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByBankId(Long bankId);
    Client findClientByAccountId(Long accountId);
}
