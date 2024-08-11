package com.semicolon.services.serviceInterface;

import com.semicolon.data.models.User;
import com.semicolon.dto.request.UserDtoRequest;
import com.semicolon.dto.request.UserUpdateRequest;
import com.semicolon.dto.response.UserCreateResponse;
import com.semicolon.dto.response.UserDeleteRequest;
import com.semicolon.dto.response.UserDtoResponse;
import com.semicolon.dto.response.UserUpdateResponse;


import java.util.List;

public interface UserService {
    List<User> getAllUser();
    UserCreateResponse createUser(UserDtoRequest userDtoRequest);
    UserUpdateResponse updateContactByUser(UserUpdateRequest userUpdateRequest);
    String deleteUserById(UserDeleteRequest userDeleteRequest);
    UserDtoResponse getUserById(UserDtoRequest userDtoResponse);

}
