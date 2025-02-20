package com.ebaad.banking_application.service;

import com.ebaad.banking_application.dto.AccountDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO);

    List<AccountDTO> showAllAccounts();

    AccountDTO getAccountById(Long id);

    AccountDTO getAccountByName(String accountHolderName);

    AccountDTO updateAccount(Long id, AccountDTO accountDTO);

    AccountDTO deleteAccount(Long id);

    AccountDTO deposit(Long id, double amount);

    AccountDTO withdraw(Long id, double amount);
}
