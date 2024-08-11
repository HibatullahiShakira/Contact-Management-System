package com.semicolon.services.serviceInterface;


import com.semicolon.dto.request.ContactGroupDeleteRequest;
import com.semicolon.dto.request.ContactGroupDtoRequest;
import com.semicolon.dto.request.ContactGroupUpdateRequest;
import com.semicolon.dto.response.ContactGroupCreateResponse;
import com.semicolon.dto.response.ContactGroupDtoResponse;
import com.semicolon.dto.response.ContactGroupUpdateResponse;


import java.util.List;

public interface ContactGroupService {
    ContactGroupCreateResponse createContactGroup(ContactGroupDtoRequest contactGroupDtoRequest);
    List<ContactGroupDtoResponse> getAllContactGroup();
    ContactGroupUpdateResponse updateContactGroupByGroupName(ContactGroupUpdateRequest contactGroupUpdateRequest);
    void deleteContactGroupByGroupName(ContactGroupDeleteRequest groupName);
    ContactGroupUpdateResponse getContactGroupByGroupName(ContactGroupUpdateRequest groupName);
}
