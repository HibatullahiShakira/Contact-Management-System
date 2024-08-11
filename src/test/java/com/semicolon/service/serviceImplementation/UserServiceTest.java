package com.semicolon.service.serviceImplementation;

import com.semicolon.data.models.User;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.UserCreateResponse;
import com.semicolon.dto.response.UserDeleteRequest;
import com.semicolon.dto.response.UserUpdateResponse;
import com.semicolon.repositories.UserRepository;
import com.semicolon.services.serviceInterface.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    void setup(){
        userRepository.deleteAll();
    }
    @Autowired
    private UserService userService;




    @Test
    public void testCreateUser() {
        UserDtoRequest userDtoRequest = new UserDtoRequest();
        userDtoRequest.setFirstName("John");
        userDtoRequest.setLastName("Doe");
        userDtoRequest.setEmail("john.doe@gmail.com");
        userDtoRequest.setPassword("password");
        userDtoRequest.setPhoneNumber("1234567890");
        userDtoRequest.setUserName("JohnDoe");
        UserCreateResponse userCreateResponse = userService.createUser(userDtoRequest);
        assertEquals(userCreateResponse.getMessage(), "User created successfully");
    }

    @Test
    public void testUpdateUser() {
        UserDtoRequest userDtoRequest = new UserDtoRequest();
        userDtoRequest.setFirstName("John");
        userDtoRequest.setLastName("Doe");
        userDtoRequest.setEmail("john.doe@gmail.com");
        userDtoRequest.setUserName("doey");
        userDtoRequest.setPhoneNumber("898909");
        userDtoRequest.setPassword("password");
        UserCreateResponse userCreateResponse  = userService.createUser(userDtoRequest);
        assertEquals(userCreateResponse.getMessage(), "User created successfully");


        UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
        userUpdateRequest.setFirstName("John");
        userUpdateRequest.setLastName("Doe");
        userUpdateRequest.setPhoneNumber("898909");
        userUpdateRequest.setId(userCreateResponse.getId());
        UserUpdateResponse userUpdateResponse =  userService.updateContactByUser(userUpdateRequest);
        assertEquals(userUpdateResponse.getMessage(), "user updated successfully");
    }

    @Test
    public void testDeleteUser() {
        UserDtoRequest userDtoRequest = new UserDtoRequest();
        userDtoRequest.setFirstName("John");
        userDtoRequest.setLastName("Doe");
        userDtoRequest.setEmail("john.doe@gmail.com");
        userDtoRequest.setPhoneNumber("898909");
        UserCreateResponse userCreateResponse = userService.createUser(userDtoRequest);
        UserDeleteRequest userDeleteRequest = new UserDeleteRequest();
        userDeleteRequest.setId(userCreateResponse.getId());
        String response = userService.deleteUserById(userDeleteRequest);
        assertEquals(response, "User deleted successfully");
    }

    @Test
    public void testFindAllContacts() {
        UserDtoRequest userDtoRequest = new UserDtoRequest();
        userDtoRequest.setFirstName("John");
        userDtoRequest.setLastName("Doe");
        userDtoRequest.setEmail("john.doe@gmail.com");
        userDtoRequest.setPhoneNumber("898909");
        userService.createUser(userDtoRequest);
        List<User> userList = userService.getAllUser();
        assertEquals(userList.size(), 1);
    }
}
