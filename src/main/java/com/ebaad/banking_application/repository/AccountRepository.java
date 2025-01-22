package com.ebaad.banking_application.repository;

import com.ebaad.banking_application.dto.AccountDTO;
import com.ebaad.banking_application.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // As findByName is not in JpaRepository, so we need to write it explicitly
    Optional<Account> findByAccountHolderName(String accountHolderName);
}
