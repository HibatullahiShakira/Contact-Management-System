package com.semicolon.dto.request;

import com.semicolon.data.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContactDtoRequest {
        private User user;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String address;

}
