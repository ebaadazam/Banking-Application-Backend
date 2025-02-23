package com.ebaad.banking_application.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private String name;
    private String email;
    private String subject;
    private String message;
}
