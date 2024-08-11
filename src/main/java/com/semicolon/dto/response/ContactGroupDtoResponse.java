package com.semicolon.dto.response;

import com.semicolon.data.models.Contact;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ContactGroupDtoResponse {
    private String groupName;
    private String groupDescription;
    private List<Contact> contacts;
}
