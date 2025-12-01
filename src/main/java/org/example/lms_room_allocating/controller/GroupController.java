package org.example.lms_room_allocating.controller;

import org.example.lms_room_allocating.dtos.GroupDTO;
import org.example.lms_room_allocating.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.example.lms_room_allocating.common.app_constants.AppConstants.API_VERSION;

@RestController
@RequestMapping(API_VERSION+"/group")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody GroupDTO groupDTO) {
        return groupService.create(groupDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody GroupDTO groupDTO) {
        return groupService.update(groupDTO);
    }

    @GetMapping("/allRoom")
    public ResponseEntity<?> allRoom() {
        return groupService.getAllGroup();
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable String id) {
        return groupService.remove(id);
    }
}
