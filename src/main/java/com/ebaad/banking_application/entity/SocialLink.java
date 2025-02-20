package com.ebaad.banking_application.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

}
