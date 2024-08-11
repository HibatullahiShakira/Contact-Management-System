package com.semicolon.dto.response;

import com.semicolon.data.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContactCreateResponse {
    private String firstName;
    private String lastName;
    private String message;
}
