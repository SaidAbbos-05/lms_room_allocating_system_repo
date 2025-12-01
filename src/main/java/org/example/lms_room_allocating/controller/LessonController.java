package org.example.lms_room_allocating.controller;


import org.example.lms_room_allocating.dtos.LessonDTO;
import org.example.lms_room_allocating.service.LessonService;
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
@RequestMapping(API_VERSION+"/lesson")
public class LessonController {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody LessonDTO lessonDTO) {
        return lessonService.create(lessonDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody LessonDTO lessonDTO) {
        return lessonService.update(lessonDTO);
    }

    @GetMapping("/allRoom")
    public ResponseEntity<?> allRoom() {
        return lessonService.getAllRoom();
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable String id) {
        return lessonService.remove(id);
    }
}
