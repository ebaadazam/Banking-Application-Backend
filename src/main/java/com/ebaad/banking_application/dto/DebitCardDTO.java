package com.ebaad.banking_application.dto;

public class DebitCardDTO {
    private String cardNumber;
    private String cardName;
    private String validity; // Changed to String (MM/YY)

    public DebitCardDTO() {}

    public DebitCardDTO(String cardNumber, String cardName, String validity) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.validity = validity;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }
}
