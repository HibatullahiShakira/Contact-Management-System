package com.semicolon.Controller;

import com.semicolon.data.models.User;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.*;
import com.semicolon.services.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getContactGroups() {
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("user")
    public ResponseEntity<UserDtoResponse> getContact(@RequestBody UserDtoRequest userDtoRequest) {
        return ResponseEntity.ok(userService.getUserById(userDtoRequest));
    }

    @PostMapping("user/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserCreateResponse> createContactGroup(@RequestBody UserDtoRequest userDtoRequest) {
        return ResponseEntity.ok(userService.createUser(userDtoRequest));
    }

    @PutMapping("user/update")
    public ResponseEntity<UserUpdateResponse> updateContact(@RequestBody UserUpdateRequest userUpdateRequest) {
        UserUpdateResponse response = userService.updateContactByUser(userUpdateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("user/delete")
    public ResponseEntity<String> deleteContact(@RequestBody UserDeleteRequest userDeleteRequest) {
        userService.deleteUserById(userDeleteRequest);
        return new ResponseEntity<>("Contact deleted sucessfully", HttpStatus.OK);
    }

}
