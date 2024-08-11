package com.semicolon.repositories;

import com.semicolon.data.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ContactRepository extends MongoRepository<Contact, String> {
    Contact findByPhone(String phone);
    List<Contact> findByFirstName(String firstName);
}
