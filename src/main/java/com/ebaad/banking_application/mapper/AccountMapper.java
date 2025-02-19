package com.ebaad.banking_application.mapper;

import com.ebaad.banking_application.dto.AccountDTO;
import com.ebaad.banking_application.dto.DebitCardDTO;
import com.ebaad.banking_application.dto.SocialLinkDTO;
import com.ebaad.banking_application.entity.Account;
import com.ebaad.banking_application.entity.DebitCard;
import com.ebaad.banking_application.entity.SocialLink;

public class AccountMapper {

    public static Account mapToAccount(AccountDTO accountDTO){
        if (accountDTO == null) {
            return null;
        }

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
                accountDTO.getGender(),
                accountDTO.getImageUrl()
        );
        if (accountDTO.getDebitCard() != null) {
            DebitCardDTO debitCardDTO = accountDTO.getDebitCard();
            DebitCard debitCard = new DebitCard();
            debitCard.setCardNumber(debitCardDTO.getCardNumber());
            debitCard.setCardName(debitCardDTO.getCardName());
            debitCard.setValidity(debitCardDTO.getValidity());
            debitCard.setAccount(account);
            account.setDebitCard(debitCard);
        }

        // Map SocialLinks
        if (accountDTO.getSocialLinks() != null) {
            SocialLinkDTO socialLinkDTO = accountDTO.getSocialLinks();
            SocialLink socialLink = new SocialLink();
            socialLink.setInstagram(socialLinkDTO.getInstagram());
            socialLink.setFacebook(socialLinkDTO.getFacebook());
            socialLink.setTwitter(socialLinkDTO.getTwitter());
            socialLink.setWhatsApp(socialLinkDTO.getWhatsApp());
            socialLink.setAccount(account);
            account.getSocialLinks().add(socialLink);
        }

        return account;
    }

    public static AccountDTO mapToAccountDTO(Account account){
        if (account == null) {
            return null;
        }

        DebitCardDTO debitCardDTO = null;
        if (account.getDebitCard() != null) {
            DebitCard debitCard = account.getDebitCard();
            debitCardDTO = new DebitCardDTO(debitCard.getCardNumber(), debitCard.getCardName(), debitCard.getValidity());
        }

        // Map SocialLinks
        SocialLinkDTO socialLinkDTO = null;
        if (!account.getSocialLinks().isEmpty()) {
            SocialLink socialLink = account.getSocialLinks().get(0); // Assuming one-to-one relationship
            socialLinkDTO = new SocialLinkDTO();
            socialLinkDTO.setInstagram(socialLink.getInstagram());
            socialLinkDTO.setFacebook(socialLink.getFacebook());
            socialLinkDTO.setTwitter(socialLink.getTwitter());
            socialLinkDTO.setWhatsApp(socialLink.getWhatsApp());
        }

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
                account.getGender(),
                account.getImageUrl()
        );
        accountDTO.setDebitCard(debitCardDTO);
        accountDTO.setSocialLinks(socialLinkDTO);

        return accountDTO;
    }
}