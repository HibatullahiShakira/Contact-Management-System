package com.semicolon.dto.request;

import com.semicolon.data.models.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
public class UserUpdateRequest {
    @Id
    private String id;
    private User user;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
