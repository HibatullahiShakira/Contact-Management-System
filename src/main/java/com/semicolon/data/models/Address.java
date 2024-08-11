package com.semicolon.data.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter @ToString @Document
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String houseNumber;
}
