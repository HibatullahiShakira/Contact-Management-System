package com.semicolon.Controller;

import com.semicolon.data.models.Contact;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.ContactCreateResponse;
import com.semicolon.dto.response.ContactUpdateResponse;
import com.semicolon.services.serviceInterface.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/")
@Service
public class ContactController {
    private final ContactService contactService;

        @Autowired
        public ContactController(ContactService contactService) {
            this.contactService = contactService;
        }

        @GetMapping("contacts")
        public ResponseEntity<List<Contact>> getContactGroups() {
            return new ResponseEntity<>(contactService.getAllContacts(), HttpStatus.OK);
        }

        @GetMapping("contact")
        public ResponseEntity<ContactDtoResponse> getContact(@RequestBody ContactDtoRequest contactDtoRequest) {
            return ResponseEntity.ok(contactService.getContactByPhoneNumber(contactDtoRequest));
        }

        @PostMapping("contact/create")
        @ResponseStatus(HttpStatus.CREATED)
        public ResponseEntity<ContactCreateResponse> createContactGroup(@RequestBody ContactDtoRequest contactDtoRequest) {
            return ResponseEntity.ok(contactService.createContact(contactDtoRequest));
        }

        @PutMapping("contact/update")
        public ResponseEntity<ContactUpdateResponse> updateContact(@RequestBody ContactUpdateRequest contactUpdateRequest) {
            ContactUpdateResponse response = contactService.updateContactByPhoneNumber(contactUpdateRequest);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        @DeleteMapping("contact/delete")
        public ResponseEntity<String> deleteContact(@RequestBody ContactDeleteRequest contactDeleteRequest) {
            contactService.deleteContactByPhoneNumber(contactDeleteRequest);
            return new ResponseEntity<>("Contact deleted sucessfully", HttpStatus.OK);
        }

        @GetMapping("contact_by_name")
        public ResponseEntity<List<ContactDtoResponse>> getContactByFirstName(@RequestBody ContactDtoRequest contactDtoRequest) {
            return new ResponseEntity<>(contactService.getContactByFirstName(contactDtoRequest), HttpStatus.OK);
        }


}
