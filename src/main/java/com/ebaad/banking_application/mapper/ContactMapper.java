package com.ebaad.banking_application.mapper;

import com.ebaad.banking_application.dto.ContactDTO;
import com.ebaad.banking_application.entity.Contact;

public class ContactMapper {

    public static ContactDTO mapToContactDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setName(contact.getName());
        contactDTO.setEmail(contact.getEmail());
        contactDTO.setSubject(contact.getSubject());
        contactDTO.setMessage(contact.getMessage());
        return contactDTO;
    }

    public static Contact mapToContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setName(contactDTO.getName());
        contact.setEmail(contactDTO.getEmail());
        contact.setSubject(contactDTO.getSubject());
        contact.setMessage(contactDTO.getMessage());
        return contact;
    }
}
