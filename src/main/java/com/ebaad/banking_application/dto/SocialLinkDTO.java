package com.ebaad.banking_application.dto;

public class SocialLinkDTO {
    private String instagram;
    private String facebook;
    private String twitter;
    private String whatsApp;

    public SocialLinkDTO(){ }

    public SocialLinkDTO(String instagram, String facebook, String twitter, String whatsApp) {
        this.instagram = instagram;
        this.facebook = facebook;
        this.twitter = twitter;
        this.whatsApp = whatsApp;
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
}
