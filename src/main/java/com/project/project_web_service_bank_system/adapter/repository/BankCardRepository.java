package com.project.project_web_service_bank_system.adapter.repository;

import com.project.project_web_service_bank_system.domain.entity.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
Репозиторий, связочка с сервером и бд(BankCard), помогает сохранять информацию в бд и получать ее оттуда
 */

@Repository
public interface BankCardRepository extends JpaRepository<BankCard, Long> {
}
