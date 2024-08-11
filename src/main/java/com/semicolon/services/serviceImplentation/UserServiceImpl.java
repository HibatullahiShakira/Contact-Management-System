package com.semicolon.services.serviceImplentation;

import com.semicolon.data.models.User;
import com.semicolon.dto.request.*;
import com.semicolon.dto.response.*;
import com.semicolon.repositories.UserRepository;
import com.semicolon.services.serviceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private long count;


        @Autowired
        public UserServiceImpl(UserRepository userRepository) {
            this.userRepository = userRepository;
        }


        @Override
        public List<User> getAllUser() {
            List<User> users = userRepository.findAll();
            return users;
        }


        @Override
        public UserCreateResponse createUser(UserDtoRequest userDtoRequest) {
            User user = new User();
            user.setFirstName(userDtoRequest.getFirstName());
            user.setLastName(userDtoRequest.getLastName());
            user.setEmail(userDtoRequest.getEmail());
            user.setPhoneNumber(userDtoRequest.getPhoneNumber());
            user.setPassword(userDtoRequest.getPassword());
            user.setUserName(userDtoRequest.getUserName());
            userRepository.save(user);
            UserCreateResponse userCreateResponse = new UserCreateResponse();
            userCreateResponse.setId(user.getId());
            userCreateResponse.setMessage("User created successfully");
            count++;
            return userCreateResponse;

        }

        @Override
        public UserUpdateResponse updateContactByUser(UserUpdateRequest userUpdateRequest) {
            User foundUser = userRepository.findById(userUpdateRequest.getId()).orElse(null);
            if (foundUser == null) {
                throw new NullPointerException("User not found");
            } else {
                if (userUpdateRequest.getFirstName() != null) {
                    foundUser.setFirstName(userUpdateRequest.getFirstName());
                }
                if (userUpdateRequest.getLastName() != null) {
                    foundUser.setLastName(userUpdateRequest.getLastName());
                }
                if (userUpdateRequest.getEmail() != null) {
                    foundUser.setEmail(userUpdateRequest.getEmail());
                }
                if (userUpdateRequest.getPhoneNumber() != null) {
                    foundUser.setPhoneNumber(userUpdateRequest.getPhoneNumber());
                }
                if (userUpdateRequest.getPassword() != null) {
                    foundUser.setPassword(userUpdateRequest.getPassword());
                }
                if (userUpdateRequest.getUserName() != null) {
                    foundUser.setUserName(userUpdateRequest.getUserName());
                }
                userRepository.save(foundUser);
            }
            return new UserUpdateResponse("user updated successfully");
        }

            @Override
            public String deleteUserById(UserDeleteRequest userDeleteRequest){
                User foundUser = userRepository.findById(userDeleteRequest.getId()).orElse(null);
                if (foundUser == null) {
                    throw new NullPointerException("Contact not found");
                } else {
                    userRepository.delete(foundUser);
                }
                return "User deleted successfully";
            }

            @Override
            public UserDtoResponse getUserById(UserDtoRequest userDtoRequest){
                UserDtoResponse userDtoResponse = new UserDtoResponse();
                User user = userRepository.findById(userDtoRequest.getId()).orElse(null);
                if (user == null) {
                    throw new NullPointerException("User not found");
                } else {
                    userDtoRequest.setFirstName(user.getFirstName());
                    userDtoRequest.setLastName(user.getLastName());
                    userDtoRequest.setEmail(user.getEmail());
                    userDtoRequest.setPhoneNumber(user.getPhoneNumber());
                    userDtoRequest.setId(user.getId());
                    userDtoRequest.setUserName(user.getUserName());
                }
                return userDtoResponse;
            }

        }
