package com.ebaad.banking_application.controller;

import com.ebaad.banking_application.dto.AccountDTO;
import com.ebaad.banking_application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/banking")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // method to create an account (with image)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AccountDTO> createAccount(
            @RequestPart("accountDTO") AccountDTO accountDTO,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                String imageUrl = saveImage(file);
                accountDTO.setImageUrl(imageUrl);
            }

            AccountDTO createdAccount = accountService.createAccount(accountDTO);
            return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // method to display all accounts
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

    // method to update an account through id (image currently not updating)
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AccountDTO> updateAccount(
            @PathVariable Long id,
            @RequestPart("accountDTO") AccountDTO accountDTO,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                String imageUrl = saveImage(file);
                accountDTO.setImageUrl(imageUrl);
            }

            AccountDTO updatedAccount = accountService.updateAccount(id, accountDTO);
            return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

    // method to transfer from one account to another
    private String saveImage(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String uploadDir = "uploads/";
        Path path = Paths.get(uploadDir + fileName);
        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());
        return "/api/banking/images/" + fileName;
    }

    // method to get the image
    @GetMapping("/images/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) {
        try {
            Path path = Paths.get("uploads/" + imageName);
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)  // Or PNG, depending on your file type
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}