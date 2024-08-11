package com.semicolon.dto.request;

import com.semicolon.data.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ContactDeleteRequest {
    private User user;
    private String phoneNumber;
}
