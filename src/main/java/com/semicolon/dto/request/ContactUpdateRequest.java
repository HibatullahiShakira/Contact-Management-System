package com.semicolon.dto.request;

import com.semicolon.data.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContactUpdateRequest {
    private User user;
    private String phoneNumber;
    private String email;
    private String address;
    private String lastName;
    private String firstName;
}
