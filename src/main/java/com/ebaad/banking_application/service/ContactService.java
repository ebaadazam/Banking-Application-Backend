package com.ebaad.banking_application.service;

import com.ebaad.banking_application.dto.ContactDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    public ContactDTO createContact(ContactDTO contactDTO);

    public List<ContactDTO> getAllContacts();
}
