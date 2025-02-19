package com.ebaad.banking_application.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "social_links")
public class SocialLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String instagram;
    private String facebook;
    private String twitter;
    private String whatsApp;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public SocialLink(){ }

    public SocialLink(Long id, String instagram, String facebook, String twitter, String whatsApp, Account account) {
        this.id = id;
        this.instagram = instagram;
        this.facebook = facebook;
        this.twitter = twitter;
        this.whatsApp = whatsApp;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        this.whatsApp = whatsApp;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
