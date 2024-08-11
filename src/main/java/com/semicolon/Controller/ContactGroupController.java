package com.semicolon.Controller;

import com.semicolon.dto.request.ContactGroupDeleteRequest;
import com.semicolon.dto.request.ContactGroupDtoRequest;
import com.semicolon.dto.request.ContactGroupUpdateRequest;
import com.semicolon.dto.response.ContactGroupCreateResponse;
import com.semicolon.dto.response.ContactGroupDtoResponse;
import com.semicolon.dto.response.ContactGroupUpdateResponse;
import com.semicolon.services.serviceInterface.ContactGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@Service
public class ContactGroupController {
    private ContactGroupService contactGroupService;

    @Autowired
    public ContactGroupController(ContactGroupService contactGroupService) {
        this.contactGroupService = contactGroupService;
    }

    @GetMapping("contactGroups")
    public ResponseEntity<List<ContactGroupDtoResponse>> getContactGroups() {
        return new ResponseEntity<>(contactGroupService.getAllContactGroup(), HttpStatus.OK);
    }

    @GetMapping("contactGroup")
    public ResponseEntity<ContactGroupUpdateResponse> getContactGroup(@RequestBody ContactGroupUpdateRequest contactGroupUpdateRequest) {
        return new ResponseEntity<>(contactGroupService.getContactGroupByGroupName(contactGroupUpdateRequest), HttpStatus.OK);
    }

    @PostMapping("contactGroup/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContactGroupCreateResponse> createContactGroup(@RequestBody ContactGroupDtoRequest contactGroupDtoRequest) {
        return ResponseEntity.ok(contactGroupService.createContactGroup(contactGroupDtoRequest));
    }

    @PutMapping("contactGroup/update")
    public ResponseEntity<ContactGroupUpdateResponse> updateContact(@RequestBody ContactGroupUpdateRequest contactGroupUpdateRequest) {
        ContactGroupUpdateResponse response = contactGroupService.updateContactGroupByGroupName(contactGroupUpdateRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("contact/{groupName}")
    public ResponseEntity<String> deleteContact(@PathVariable ContactGroupDeleteRequest contactGroupDeleteRequest) {
        contactGroupService.deleteContactGroupByGroupName(contactGroupDeleteRequest);
        return new ResponseEntity<>("Contact deleted sucessfully", HttpStatus.OK);
    }

}
