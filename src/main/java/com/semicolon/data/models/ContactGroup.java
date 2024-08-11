package com.semicolon.data.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class ContactGroup {
    private String groupName;
    private String groupDescription;
    private List<Contact> contacts;
}
