package com.ebaad.banking_application.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DebitCardDTO {
    private String cardNumber;
    private String cardName;
    private String validity;
}
