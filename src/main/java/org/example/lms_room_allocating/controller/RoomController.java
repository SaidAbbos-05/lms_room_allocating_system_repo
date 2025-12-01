package org.example.lms_room_allocating.controller;

import org.example.lms_room_allocating.dtos.RoomDTO;
import org.example.lms_room_allocating.service.RoomService;
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
@RequestMapping(API_VERSION+"/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody RoomDTO roomDTO) {
        return roomService.create(roomDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody RoomDTO roomDTO) {
        return roomService.update(roomDTO);
    }

    @GetMapping("/allRoom")
    public ResponseEntity<?> allRoom() {
        return roomService.getAllRoom();
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable String id) {
        return roomService.remove(id);
    }

}
