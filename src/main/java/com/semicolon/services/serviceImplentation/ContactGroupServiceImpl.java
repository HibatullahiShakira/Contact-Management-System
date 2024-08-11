package com.semicolon.services.serviceImplentation;

import com.semicolon.data.models.ContactGroup;
import com.semicolon.dto.request.ContactGroupDeleteRequest;
import com.semicolon.dto.request.ContactGroupDtoRequest;
import com.semicolon.dto.request.ContactGroupUpdateRequest;
import com.semicolon.dto.response.ContactGroupCreateResponse;
import com.semicolon.dto.response.ContactGroupDtoResponse;
import com.semicolon.dto.response.ContactGroupUpdateResponse;
import com.semicolon.repositories.ContactGroupRepository;
import com.semicolon.services.serviceInterface.ContactGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactGroupServiceImpl implements ContactGroupService {
    private ContactGroupRepository contactGroupRepository;

    @Autowired
    public ContactGroupServiceImpl(ContactGroupRepository contactGroupRepository) {
        this.contactGroupRepository = contactGroupRepository;
    }



    @Override
    public ContactGroupCreateResponse createContactGroup(ContactGroupDtoRequest contactGroupDtoRequest) {
        ContactGroup contactGroup = new ContactGroup();
        contactGroup.setGroupName(contactGroupDtoRequest.getGroupName());
        contactGroup.setContacts(contactGroupDtoRequest.getContacts());
        contactGroup.setGroupDescription(contactGroupDtoRequest.getGroupDescription());

       contactGroupRepository.save(contactGroup);

        ContactGroupDtoRequest newContactGroupDtoRequest1 = new ContactGroupDtoRequest();
        newContactGroupDtoRequest1.setGroupName(newContactGroupDtoRequest1.getGroupName());
        newContactGroupDtoRequest1.setContacts(newContactGroupDtoRequest1.getContacts());
        newContactGroupDtoRequest1.setGroupDescription(newContactGroupDtoRequest1.getGroupDescription());

        ContactGroupCreateResponse contactGroupCreateResponse = new ContactGroupCreateResponse();
        contactGroupCreateResponse.setGroupName(contactGroup.getGroupName());
        contactGroupCreateResponse.setMessage("Contact group created successfully.");
        return contactGroupCreateResponse;
    }

    @Override
    public List<ContactGroupDtoResponse> getAllContactGroup() {
        List<ContactGroup> contactGroups = contactGroupRepository.findAll();
        List<ContactGroupDtoResponse> contactGroupDtoList = new ArrayList<>();
        if (contactGroups == null) {
            throw new NullPointerException("List of Contact group not found");
        }
        else {
            for (ContactGroup contactGroup : contactGroups) {
                ContactGroupDtoResponse contactGroupDtoResponse = new ContactGroupDtoResponse();
                contactGroupDtoResponse.setGroupName(contactGroup.getGroupName());
                contactGroupDtoResponse.setContacts(contactGroup.getContacts());
                contactGroupDtoResponse.setGroupDescription(contactGroup.getGroupDescription());

                contactGroupDtoList.add(contactGroupDtoResponse);
                return contactGroupDtoList;
            }
        }
        return contactGroupDtoList;
    }

    @Override
    public ContactGroupUpdateResponse updateContactGroupByGroupName(ContactGroupUpdateRequest contactGroupUpdateRequest) {
        ContactGroup contactGroup = contactGroupRepository.findByGroupName(contactGroupUpdateRequest.getGroupName());
        if (contactGroup == null) {
            throw new NullPointerException("Contact group not found");
        }else {
            if (contactGroupUpdateRequest.getGroupName() != null) {
                contactGroup.setGroupName(contactGroupUpdateRequest.getGroupName());
            }
            if (contactGroupUpdateRequest.getGroupDescription() != null) {
                contactGroup.setGroupDescription(contactGroupUpdateRequest.getGroupDescription());
            }
        }

        return new ContactGroupUpdateResponse("Contact Updated sucessfully");
    }

    @Override
    public void deleteContactGroupByGroupName(ContactGroupDeleteRequest contactGroupDeleteRequest) {
        ContactGroup contactGroup = contactGroupRepository.findByGroupName(contactGroupDeleteRequest.getGroupName());
        contactGroupRepository.delete(contactGroup);
    }

    @Override
    public ContactGroupUpdateResponse getContactGroupByGroupName(ContactGroupUpdateRequest groupName) {
        ContactGroup contactGroup = contactGroupRepository.findByGroupName(groupName.getGroupName());
        if (contactGroup == null) {
            throw new NullPointerException("Contact group not found");
        }
            return new ContactGroupUpdateResponse("Contact group updated successfully");

    }

    private ContactGroupDtoRequest setObjectValuesDto(ContactGroup contactGroup) {
        ContactGroupDtoRequest contactGroupDtoRequest = new ContactGroupDtoRequest();
        contactGroupDtoRequest.setGroupName(contactGroup.getGroupName());
        contactGroupDtoRequest.setContacts(contactGroup.getContacts());
        contactGroupDtoRequest.setGroupDescription(contactGroup.getGroupDescription());
        return contactGroupDtoRequest;
    }

    private ContactGroup setDtoValuesToObject(ContactGroupDtoRequest contactGroupDtoRequest) {
        ContactGroup contactGroup = new ContactGroup();
        contactGroup.setGroupName(contactGroupDtoRequest.getGroupName());
        contactGroup.setContacts(contactGroupDtoRequest.getContacts());
        contactGroup.setGroupDescription(contactGroupDtoRequest.getGroupDescription());
        return contactGroup;
    }
}
