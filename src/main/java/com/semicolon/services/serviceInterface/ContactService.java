package com.semicolon.services.serviceInterface;

import com.semicolon.data.models.Contact;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.ContactCreateResponse;
import com.semicolon.dto.response.ContactUpdateResponse;

import java.util.List;

public interface ContactService {
List<ContactDtoResponse> getContactByFirstName(ContactDtoRequest contactDtoRequest);
List<Contact> getAllContacts();
ContactCreateResponse createContact(ContactDtoRequest contactDtoRequest);
ContactUpdateResponse updateContactByPhoneNumber(ContactUpdateRequest contactUpdateRequest);
String deleteContactByPhoneNumber(ContactDeleteRequest contactDeleteRequest);
ContactDtoResponse getContactByPhoneNumber(ContactDtoRequest contactDtoRequest);

}
