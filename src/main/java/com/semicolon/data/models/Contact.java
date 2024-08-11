package com.semicolon.data.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter @ToString @Document
public class Contact {
    private String firstName;
    private String lastName;
    private String email;
    @Id
    private String phone;
    private String address;
}
