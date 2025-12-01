package org.example.lms_room_allocating.controller;


import org.example.lms_room_allocating.dtos.JointGroupDTO;
import org.example.lms_room_allocating.service.JointGroupService;
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
@RequestMapping(API_VERSION+"joint-group")
public class JointGroupController {

    private final JointGroupService jointGroupService;

    @Autowired
    public JointGroupController(JointGroupService jointGroupService) {
        this.jointGroupService = jointGroupService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody JointGroupDTO jointGroupDTO) {
        return jointGroupService.create(jointGroupDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody JointGroupDTO jointGroupDTO) {
        return jointGroupService.update(jointGroupDTO);
    }

    @GetMapping("/allRoom")
    public ResponseEntity<?> allRoom() {
        return jointGroupService.getAllRoom();
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable String id) {
        return jointGroupService.remove(id);
    }
}
