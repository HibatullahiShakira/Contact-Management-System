package com.semicolon.dto.request;

import com.semicolon.data.models.User;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ContactGroupDeleteRequest {
    private User user;
    private String GroupName;
}
