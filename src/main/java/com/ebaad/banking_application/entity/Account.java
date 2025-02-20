package com.ebaad.banking_application.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Column(name = "ifsc_code", unique = true)
    private String ifscCode;

    @Column(name = "account_number", unique = true)
    private double accountNumber;

    @Column(name = "account_balance")
    private double balance;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "branch_name")
    private String branchName;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    @Column(name = "account_status")
    private String accountStatus;

    @Column(name = "creation_date", updatable = false)
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    @Column(name = "last_updated_date")
    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpdatedDate;

    private String designation;

    private String address;

    private String gender;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private DebitCard debitCard;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SocialLink> socialLinks = new ArrayList<>();

    public Account(Long id, String accountHolderName, String ifscCode, double accountNumber, double balance,
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
