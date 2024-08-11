package com.semicolon.repositories;

import com.semicolon.data.models.ContactGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactGroupRepository  extends MongoRepository<ContactGroup, String> {
    ContactGroup findByGroupName(String groupName);
}
