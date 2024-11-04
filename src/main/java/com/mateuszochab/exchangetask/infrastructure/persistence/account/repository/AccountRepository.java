package com.mateuszochab.exchangetask.infrastructure.persistence.account.repository;

import com.mateuszochab.exchangetask.infrastructure.persistence.account.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    boolean existsByUuid(UUID uuid);
}
