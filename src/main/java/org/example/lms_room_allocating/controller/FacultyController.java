package org.example.lms_room_allocating.controller;


import io.swagger.v3.oas.annotations.Operation;
import org.example.lms_room_allocating.dtos.FacultyDTO;
import org.example.lms_room_allocating.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.example.lms_room_allocating.common.app_constants.AppConstants.API_VERSION;

@RestController
@RequestMapping(API_VERSION+"/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "After successfully creating Faculty, returning Faculty.obj")
    public ResponseEntity<?> create(@RequestBody FacultyDTO facultyDTO) {
        return facultyService.create(facultyDTO);
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody FacultyDTO facultyDTO) {
        return facultyService.update(facultyDTO);
    }

    @GetMapping("/allRoom")
    public ResponseEntity<?> allRoom() {
        return facultyService.getAllRoom();
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable String id) {
        return facultyService.remove(id);
    }
}
