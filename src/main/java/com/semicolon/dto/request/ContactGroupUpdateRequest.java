package com.semicolon.dto.request;

import com.semicolon.data.models.Contact;
import com.semicolon.data.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ContactGroupUpdateRequest {
    private User user;
    private String groupName;
    private String groupDescription;
    private List<Contact> contacts;
}
