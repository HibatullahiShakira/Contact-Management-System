package com.semicolon.services.serviceImplentation;

import com.semicolon.data.models.Contact;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.ContactCreateResponse;
import com.semicolon.dto.response.ContactUpdateResponse;
import com.semicolon.repositories.ContactRepository;
import com.semicolon.services.serviceInterface.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;


    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {

        this.contactRepository = contactRepository;
    }

    @Override
    public List<ContactDtoResponse> getContactByFirstName(ContactDtoRequest contactDtoRequest) {
        List<ContactDtoResponse> matchingContacts = new ArrayList<>();
        if (contactDtoRequest.getUser() != null) {
            if (contactDtoRequest.getUser() != null) {
                List<Contact> foundContacts = contactRepository.findByFirstName(contactDtoRequest.getFirstName());
                if (foundContacts == null) {
                    throw new NullPointerException("Contact not found");
                }
                for (Contact contact : foundContacts) {
                    ContactDtoResponse FoundContactDto = setObjectValuesDto(contact);
                    matchingContacts.add(FoundContactDto);

                }
            }
        }
        return matchingContacts;
    }

    @Override
    public List<Contact> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        if (contacts == null) {
            throw new NullPointerException("List of Contact not found");
        }
        return contacts;
    }


    @Override
    public ContactCreateResponse createContact(ContactDtoRequest contactDtoRequest) {
        ContactCreateResponse contactCreateResponse = new ContactCreateResponse();
        if(contactDtoRequest.getUser() != null) {
            Contact createdContact = setDtoValuesToObject(contactDtoRequest);
            contactRepository.save(createdContact);
            contactCreateResponse.setFirstName(createdContact.getFirstName());
            contactCreateResponse.setLastName(createdContact.getLastName());
            contactCreateResponse.setMessage("Contact created successfully");
        }
        return contactCreateResponse;
    }

    @Override
    public ContactUpdateResponse updateContactByPhoneNumber(ContactUpdateRequest contactUpdateRequest) {
        if(contactUpdateRequest.getUser() != null) {
            Contact foundContact = contactRepository.findByPhone(contactUpdateRequest.getPhoneNumber());
            if (foundContact == null) {
                throw new NullPointerException("Contact not found");
            } else {
                if (contactUpdateRequest.getFirstName() != null) {
                    foundContact.setFirstName(contactUpdateRequest.getFirstName());
                }
                if (contactUpdateRequest.getLastName() != null) {
                    foundContact.setLastName(contactUpdateRequest.getLastName());
                }
                if (contactUpdateRequest.getPhoneNumber() != null) {
                    foundContact.setPhone(contactUpdateRequest.getPhoneNumber());
                }
                if (contactUpdateRequest.getEmail() != null) {
                    foundContact.setEmail(contactUpdateRequest.getEmail());
                }
                if (contactUpdateRequest.getAddress() != null) {
                    foundContact.setAddress(contactUpdateRequest.getAddress());
                }
                contactRepository.save(foundContact);
                //ContactUpdateResponse contactUpdateResponse = new ContactUpdateResponse("Contact update sucessfully");
            }
        }
        return new ContactUpdateResponse("Contact update successfully");
    }

    @Override
    public String deleteContactByPhoneNumber(ContactDeleteRequest contactDeleteRequest) {
        if(contactDeleteRequest.getUser() != null) {
        Contact foundContact = contactRepository.findByPhone(contactDeleteRequest.getPhoneNumber());
        if (foundContact == null) {
            throw new NullPointerException("Contact not found");
        }
            contactRepository.delete(foundContact);
        }
        return "Contact deleted successfully";
    }

    @Override
    public ContactDtoResponse getContactByPhoneNumber(ContactDtoRequest contactDtoRequest) {
        ContactDtoResponse foundContactDto;
        if(contactDtoRequest.getUser() != null) {
            Contact foundContact = contactRepository.findByPhone(contactDtoRequest.getPhone());
            if (foundContact == null) {
                throw new NullPointerException("Contact not found");
            }
                foundContactDto = setObjectValuesDto(foundContact);
            return foundContactDto;

        }throw new NullPointerException("User not found");
        }

    private ContactDtoResponse setObjectValuesDto(Contact contact) {
        ContactDtoResponse contactDtoResponse = new ContactDtoResponse();
        contactDtoResponse.setAddress(contact.getAddress());
        contactDtoResponse.setEmail(contact.getEmail());
        contactDtoResponse.setFirstName(contact.getFirstName());
        contactDtoResponse.setLastName(contact.getLastName());
        contactDtoResponse.setPhone(contact.getPhone());
        return contactDtoResponse;
    }

    private Contact setDtoValuesToObject(ContactDtoRequest contactDtoRequest) {
        Contact contact = new Contact();
        contact.setAddress(contactDtoRequest.getAddress());
        contact.setEmail(contactDtoRequest.getEmail());
        contact.setFirstName(contactDtoRequest.getFirstName());
        contact.setLastName(contactDtoRequest.getLastName());
        contact.setPhone(contactDtoRequest.getPhone());
        return contact;
    }
}