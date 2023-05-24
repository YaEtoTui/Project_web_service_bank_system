package com.project.project_web_service_bank_system.adapter.repository;

import com.project.project_web_service_bank_system.domain.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
Репозиторий, связочка с сервером и бд(Bank), помогает сохранять информацию в бд и получать ее оттуда
 */

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    List<Bank> findAllByName(String name);
}
