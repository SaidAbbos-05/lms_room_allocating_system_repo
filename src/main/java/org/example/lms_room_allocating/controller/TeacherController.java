package org.example.lms_room_allocating.controller;

import org.example.lms_room_allocating.dtos.TeacherDTO;
import org.example.lms_room_allocating.service.TeacherService;
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
@RequestMapping(API_VERSION+"/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.create(teacherDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.update(teacherDTO);
    }

    @GetMapping("/allRoom")
    public ResponseEntity<?> allRoom() {
        return teacherService.getAllRoom();
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable String id) {
        return teacherService.remove(id);
    }
}

