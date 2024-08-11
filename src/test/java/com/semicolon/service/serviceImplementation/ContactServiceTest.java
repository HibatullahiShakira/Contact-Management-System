package com.semicolon.service.serviceImplementation;


import com.semicolon.data.models.Contact;
import com.semicolon.data.models.User;
import com.semicolon.dto.request.ContactDeleteRequest;
import com.semicolon.dto.request.ContactDtoRequest;
import com.semicolon.dto.request.ContactDtoResponse;
import com.semicolon.dto.request.ContactUpdateRequest;
import com.semicolon.dto.response.ContactCreateResponse;
import com.semicolon.dto.response.ContactUpdateResponse;
import com.semicolon.repositories.ContactRepository;
import com.semicolon.services.serviceInterface.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ContactServiceTest {

    @Autowired
    private ContactRepository contactRepository;
    @BeforeEach
    void setup(){
        contactRepository.deleteAll();
    }

    @Autowired
    private ContactService contactService;


    @Test
    public void testCreateContact() {
        User user = new User();
        user.setFirstName("Sam");
        user.setLastName("Smith");
        user.setEmail("sam.smith@gmail.com");
        user.setPassword("password");
        user.setUserName("sam.smith");
        user.setPhoneNumber("555-555-5555");
        user.setId(user.getId());
        ContactDtoRequest contactDtoRequest = new ContactDtoRequest();
        contactDtoRequest.setUser(user);
        contactDtoRequest.setFirstName("John");
        contactDtoRequest.setLastName("Doe");
        contactDtoRequest.setEmail("john.doe@gmail.com");
        contactDtoRequest.setAddress("Lagos");
        contactDtoRequest.setPhone("898909");
        ContactCreateResponse contactCreateResponse = contactService.createContact(contactDtoRequest);
        assertEquals(contactCreateResponse.getMessage(), "Contact created successfully");
        assertEquals(contactCreateResponse.getLastName(), contactDtoRequest.getLastName());
        assertEquals(contactCreateResponse.getFirstName(), contactDtoRequest.getFirstName());
    }

    @Test
    public void testUpdateContact() {
        User user = new User();
        user.setFirstName("Sam");
        user.setLastName("Smith");
        user.setEmail("sam.smith@gmail.com");
        user.setPassword("password");
        user.setUserName("sam.smith");
        user.setPhoneNumber("555-555-5555");
        user.setId(user.getId());
        ContactDtoRequest contactDtoRequest = new ContactDtoRequest();
        contactDtoRequest.setUser(user);
        contactDtoRequest.setFirstName("John");
        contactDtoRequest.setLastName("Doe");
        contactDtoRequest.setEmail("john.doe@gmail.com");
        contactDtoRequest.setAddress("Lagos");
        contactDtoRequest.setPhone("898909");
        contactService.createContact(contactDtoRequest);
        ContactUpdateRequest contactUpdateRequest = new ContactUpdateRequest();
        contactUpdateRequest.setFirstName("John");
        contactUpdateRequest.setLastName("Doe");
        contactUpdateRequest.setPhoneNumber("898909");
        contactUpdateRequest.setUser(user);
        ContactUpdateResponse contactUpdateResponse =  contactService.updateContactByPhoneNumber(contactUpdateRequest);
        assertEquals(contactUpdateResponse.getMessage(), "Contact update successfully");
    }

    @Test
    public void testDeleteContact() {
        User user = new User();
        user.setFirstName("Sam");
        user.setLastName("Smith");
        user.setEmail("sam.smith@gmail.com");
        user.setPassword("password");
        user.setUserName("sam.smith");
        user.setPhoneNumber("555-555-5555");
        user.setId(user.getId());
        ContactDtoRequest contactDtoRequest = new ContactDtoRequest();
        contactDtoRequest.setUser(user);
        contactDtoRequest.setFirstName("John");
        contactDtoRequest.setLastName("Doe");
        contactDtoRequest.setEmail("john.doe@gmail.com");
        contactDtoRequest.setAddress("Lagos");
        contactDtoRequest.setPhone("898909");
        contactService.createContact(contactDtoRequest);
        ContactDeleteRequest contactDeleteRequest = new ContactDeleteRequest();
        contactDeleteRequest.setPhoneNumber("898909");
        String response = contactService.deleteContactByPhoneNumber(contactDeleteRequest);
        assertEquals(response, "Contact deleted successfully");
    }

    @Test
    public void testFindAllContacts() {
        User user = new User();
        user.setFirstName("Sam");
        user.setLastName("Smith");
        user.setEmail("sam.smith@gmail.com");
        user.setPassword("password");
        user.setUserName("sam.smith");
        user.setPhoneNumber("555-555-5555");
        user.setId(user.getId());
        ContactDtoRequest contactDtoRequest = new ContactDtoRequest();
        contactDtoRequest.setUser(user);
        contactDtoRequest.setFirstName("John");
        contactDtoRequest.setLastName("Doe");
        contactDtoRequest.setEmail("john.doe@gmail.com");
        contactDtoRequest.setAddress("Lagos");
        contactDtoRequest.setPhone("898909");
        contactService.createContact(contactDtoRequest);

        List<Contact> contactDtoResponse = contactService.getAllContacts();
        assertEquals(contactDtoResponse.size(), 1);
    }

    @Test
    public void testFindContactFirstName() {
        User user = new User();
        user.setFirstName("Sam");
        user.setLastName("Smith");
        user.setEmail("sam.smith@gmail.com");
        user.setPassword("password");
        user.setUserName("sam.smith");
        user.setPhoneNumber("555-555-5555");
        user.setId(user.getId());
        ContactDtoRequest contactDtoRequest = new ContactDtoRequest();
        contactDtoRequest.setUser(user);
        contactDtoRequest.setFirstName("John");
        contactDtoRequest.setLastName("Doe");
        contactDtoRequest.setEmail("john.doe@gmail.com");
        contactDtoRequest.setAddress("Lagos");
        contactDtoRequest.setPhone("898909");
        contactService.createContact(contactDtoRequest);
        ContactDtoRequest contactDttRequest = new ContactDtoRequest();
        contactDttRequest.setFirstName("John");
        List<ContactDtoResponse> response = contactService.getContactByFirstName(contactDtoRequest);
        assertEquals(response.size(), 1);

    }

}

