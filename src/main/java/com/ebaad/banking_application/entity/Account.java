package com.ebaad.banking_application.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @Column(name = "account_number")
    private double accountNumber;

    @Column(name = "account_balance")
    private double balance;

    // additional
    @Column(name = "account_type")
    private String accountType;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    @Column(name = "account_status")
    private String accountStatus;

    @Column(name = "creation_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    @Column(name = "last_updated_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpdatedDate;

    private String designation;

    private String address;

    @Column(name = "image_url")
    private String imageUrl;

    public Account() {
    }

    public Account(Long id, String accountHolderName, String ifscCode, double accountNumber, double balance,
                   String accountType, String branchName, String phoneNumber, String email,
                   String accountStatus, LocalDate creationDate, LocalDate lastUpdatedDate,
                   String designation, String address, String imageUrl) {
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
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // additional
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDate lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
