package com.ebaad.banking_application.mapper;

import com.ebaad.banking_application.dto.AccountDTO;
import com.ebaad.banking_application.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDTO accountDTO){
        Account account = new Account(
                accountDTO.getId(),
                accountDTO.getAccountHolderName(),
                accountDTO.getIfscCode(),
                accountDTO.getAccountNumber(),
                accountDTO.getBalance(),
                accountDTO.getAccountType(),
                accountDTO.getBranchName(),
                accountDTO.getPhoneNumber(),
                accountDTO.getEmail(),
                accountDTO.getAccountStatus(),
                accountDTO.getCreationDate(),
                accountDTO.getLastUpdatedDate(),
                accountDTO.getDesignation(),
                accountDTO.getAddress(),
                accountDTO.getImageUrl()
        );
        return account;
    }

    public static AccountDTO mapToAccountDTO(Account account){
        AccountDTO accountDTO = new AccountDTO(
                account.getId(),
                account.getAccountHolderName(),
                account.getIfscCode(),
                account.getAccountNumber(),
                account.getBalance(),
                account.getAccountType(),
                account.getBranchName(),
                account.getPhoneNumber(),
                account.getEmail(),
                account.getAccountStatus(),
                account.getCreationDate(),
                account.getLastUpdatedDate(),
                account.getDesignation(),
                account.getAddress(),
                account.getImageUrl()
        );
        return accountDTO;
    }
}
