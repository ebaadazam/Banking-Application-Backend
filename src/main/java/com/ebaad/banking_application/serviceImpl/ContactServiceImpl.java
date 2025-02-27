package com.ebaad.banking_application.serviceImpl;

import com.ebaad.banking_application.dto.ContactDTO;
import com.ebaad.banking_application.entity.Contact;
import com.ebaad.banking_application.mapper.ContactMapper;
import com.ebaad.banking_application.repository.ContactRepository;
import com.ebaad.banking_application.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    @Override
    public ContactDTO createContact(ContactDTO contactDTO) {
        Contact contact = ContactMapper.mapToContact(contactDTO);
        Contact savedContact = contactRepository.save(contact);
        return ContactMapper.mapToContactDTO(savedContact);
    }

    @Override
    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream().map((contact) ->
                ContactMapper.mapToContactDTO(contact)).collect(Collectors.toList());
    }
}
