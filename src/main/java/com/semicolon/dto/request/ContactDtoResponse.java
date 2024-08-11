package com.semicolon.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContactDtoResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
