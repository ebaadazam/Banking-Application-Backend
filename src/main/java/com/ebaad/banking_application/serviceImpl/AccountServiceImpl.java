package com.ebaad.banking_application.serviceImpl;

import com.ebaad.banking_application.dto.AccountDTO;
import com.ebaad.banking_application.dto.DebitCardDTO;
import com.ebaad.banking_application.dto.SocialLinkDTO;
import com.ebaad.banking_application.entity.Account;
import com.ebaad.banking_application.entity.DebitCard;
import com.ebaad.banking_application.entity.SocialLink;
import com.ebaad.banking_application.mapper.AccountMapper;
import com.ebaad.banking_application.repository.AccountRepository;
import com.ebaad.banking_application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import com.ebaad.banking_application.exception.BankingExceptions.*;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // method to create an account
    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = AccountMapper.mapToAccount(accountDTO);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    // method to show all accounts
    @Override
    public List<AccountDTO> showAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        // converting the above Account List into AccountDTO
        return accounts
                .stream()
                .map((acc) -> AccountMapper.mapToAccountDTO(acc))
                .collect(Collectors.toList());
    }

    // method to show an account through id
    @Override
    public AccountDTO getAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new InvalidIdException("Incorrect ID is given or ID doesn't exists!"));
        AccountDTO accountDTO = AccountMapper.mapToAccountDTO(account);
        return accountDTO;
    }

    // method to show an account through name
    @Override
    public AccountDTO getAccountByName(String accountHolderName) {
        Account account = accountRepository
                .findByAccountHolderName(accountHolderName)
                .orElseThrow(()->new InvalidNameException("Account with name '" + accountHolderName + "' does not exists!"));
        return AccountMapper.mapToAccountDTO(account);
    }

    // method to update an account through id
    @Override
    public AccountDTO updateAccount(Long id, AccountDTO accountDTO) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new InvalidIdException("Incorrect ID is given or ID doesn't exists!"));

        account.setAccountHolderName(accountDTO.getAccountHolderName());
        account.setIfscCode(accountDTO.getIfscCode());
        account.setAccountNumber(accountDTO.getAccountNumber());
        account.setAccountType(accountDTO.getAccountType());
        account.setBranchName(accountDTO.getBranchName());
        account.setPhoneNumber(accountDTO.getPhoneNumber());
        account.setEmail(accountDTO.getEmail());
        account.setAccountStatus(accountDTO.getAccountStatus());
        account.setCreationDate(accountDTO.getCreationDate());
        account.setLastUpdatedDate(accountDTO.getLastUpdatedDate());
        account.setDesignation(accountDTO.getDesignation());
        account.setAddress(accountDTO.getAddress());
        account.setGender(accountDTO.getGender());

        // For DebitCard
        if (accountDTO.getDebitCard() != null) {
            DebitCardDTO debitCardDTO = accountDTO.getDebitCard();
            DebitCard debitCard = account.getDebitCard();
            if (debitCard == null) {
                debitCard = new DebitCard();
                debitCard.setAccount(account); // Set the bidirectional relationship
            }
            debitCard.setCardNumber(debitCardDTO.getCardNumber());
            debitCard.setCardName(debitCardDTO.getCardName());
            debitCard.setValidity(debitCardDTO.getValidity());

            account.setDebitCard(debitCard);
        } else {
            account.setDebitCard(null);
        }

        // Update SocialLinks
        if (accountDTO.getSocialLinks() != null) {
            SocialLinkDTO socialLinkDTO = accountDTO.getSocialLinks();
            List<SocialLink> socialLinks = account.getSocialLinks();

            // If socialLinks is empty, create a new SocialLink
            if (socialLinks.isEmpty()) {
                SocialLink socialLink = new SocialLink();
                socialLink.setInstagram(socialLinkDTO.getInstagram());
                socialLink.setFacebook(socialLinkDTO.getFacebook());
                socialLink.setTwitter(socialLinkDTO.getTwitter());
                socialLink.setWhatsApp(socialLinkDTO.getWhatsApp());
                socialLink.setAccount(account); // Set the bidirectional relationship
                socialLinks.add(socialLink);
            } else {
                // Update the existing SocialLink
                SocialLink socialLink = socialLinks.get(0); // Assuming one-to-one relationship
                socialLink.setInstagram(socialLinkDTO.getInstagram());
                socialLink.setFacebook(socialLinkDTO.getFacebook());
                socialLink.setTwitter(socialLinkDTO.getTwitter());
                socialLink.setWhatsApp(socialLinkDTO.getWhatsApp());
            }
        } else {
            // If socialLinks is null, remove all existing SocialLinks
            account.getSocialLinks().clear();
        }
        Account updatedAccount = accountRepository.save(account);
        AccountDTO acc = AccountMapper.mapToAccountDTO(updatedAccount);
        return acc;
    }

    // method to delete an account through id
    @Override
    public AccountDTO deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new InvalidIdException("Incorrect ID is given or ID doesn't exists!"));
        accountRepository.deleteById(id);
        AccountDTO accountDTO = AccountMapper.mapToAccountDTO(account);
        return accountDTO;
    }

    // method to deposit the money into the account
    @Override
    public AccountDTO deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new InvalidIdException("Incorrect ID is given or ID doesn't exists!"));
        if (amount <= 100){
            throw new InvalidAmountException("Amount should be greater than ₹100 to deposit!");
        }
        double updatedBalance = account.getBalance() + amount;
        account.setBalance(updatedBalance);
        Account deposited = accountRepository.save(account);

        AccountDTO accountDTO = AccountMapper.mapToAccountDTO(deposited);
        return accountDTO;
    }

    // method to withdraw the money from the account
    @Override
    public AccountDTO withdraw(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(()->new InvalidIdException("Incorrect ID is given or ID doesn't exists!"));

        if(account.getBalance() < amount) {
            throw new InsufficientFundsException(
                    "Insufficient Funds in Account! \n" +
                    "You can only withdraw amount below or equal to ₹" + account.getBalance());
        }
        double updatedBalance = account.getBalance() - amount;
        account.setBalance(updatedBalance);
        Account withdrawn = accountRepository.save(account);

        AccountDTO accountDTO = AccountMapper.mapToAccountDTO(withdrawn);
        return accountDTO;
    }
}
