package com.semicolon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {
    private String id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
