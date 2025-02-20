package com.ebaad.banking_application.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialLinkDTO {
    private String instagram;
    private String facebook;
    private String twitter;
    private String whatsApp;

}
