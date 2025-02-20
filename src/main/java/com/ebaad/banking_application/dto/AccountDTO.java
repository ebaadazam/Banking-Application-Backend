package com.ebaad.banking_application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AccountDTO {
    private Long id;
    private String accountHolderName;
    private String ifscCode;
    private double accountNumber;
    private double balance;
    private String accountType;
    private String branchName;
    private String phoneNumber;
    private String email;
    private String accountStatus;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpdatedDate;
    private String designation;
    private String address;
    private String gender;
    private String imageUrl;
    private DebitCardDTO debitCard;
    private SocialLinkDTO socialLinks;

    public AccountDTO(Long id, String accountHolderName, String ifscCode, double accountNumber, double balance,
                   String accountType, String branchName, String phoneNumber, String email,
                   String accountStatus, LocalDate creationDate, LocalDate lastUpdatedDate,
                   String designation, String address, String gender, String imageUrl) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.ifscCode = ifscCode;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.branchName = branchName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accountStatus = accountStatus;
        this.creationDate = creationDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.designation = designation;
        this.address = address;
        this.gender = gender;
        this.imageUrl = imageUrl;
    }
}
