package com.ebaad.banking_application.controller;

import com.ebaad.banking_application.dto.AccountDTO;
import com.ebaad.banking_application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/banking")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // method to create an account
    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO){
        AccountDTO createdAccount = accountService.createAccount(accountDTO);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    // method to show all accounts
    @GetMapping
    public ResponseEntity<List<AccountDTO>> showAllAccounts(){
        List<AccountDTO> accounts = accountService.showAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // method to show an account through id
    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> showAccountById(@PathVariable Long id){
        AccountDTO accountDTO = accountService.getAccountById(id);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    // method to show an account through name
    @GetMapping("name/{accountHolderName}")
    public ResponseEntity<AccountDTO> showAccountByName(@PathVariable String accountHolderName){
        AccountDTO accountDTO = accountService.getAccountByName(accountHolderName);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    // method to update an account through id
    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable Long id,
                                                    @RequestBody AccountDTO accountDTO) throws AccessDeniedException {
        AccountDTO updatedAccount = accountService.updateAccount(id, accountDTO);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    // method to delete an account through id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        AccountDTO updatedAccount = accountService.deleteAccount(id);
        String s = "Account with the name '" + updatedAccount.getAccountHolderName() + "' deleted";
        return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
    }

    // method to deposit an account
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDTO accountDTO = accountService.deposit(id, amount);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    // method to withdraw from an account
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDTO accountDTO = accountService.withdraw(id, amount);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }
}
