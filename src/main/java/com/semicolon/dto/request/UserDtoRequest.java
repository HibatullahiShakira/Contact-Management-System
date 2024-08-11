package com.semicolon.dto.request;

import com.semicolon.data.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDtoRequest {
    private User user;
    private String id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
