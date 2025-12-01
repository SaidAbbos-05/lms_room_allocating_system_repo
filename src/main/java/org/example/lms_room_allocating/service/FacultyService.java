package org.example.lms_room_allocating.service;

import org.example.lms_room_allocating.dtos.FacultyDTO;
import org.example.lms_room_allocating.dtos.RoomDTO;
import org.example.lms_room_allocating.model.Faculty;
import org.example.lms_room_allocating.model.Room;
import org.example.lms_room_allocating.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;
    private final ResponseMaker responseMaker;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository, ResponseMaker responseMaker) {
        this.facultyRepository = facultyRepository;
        this.responseMaker = responseMaker;
    }

    public ResponseEntity<?> create(FacultyDTO facultyDTO) {

        Faculty build = Faculty.builder()
                .name(facultyDTO.getName())
                .build();

        Faculty save = facultyRepository.save(build);
        return responseMaker.created(save);
    }

    public ResponseEntity<?> update(FacultyDTO facultyDTO) {

        Faculty build = Faculty.builder()
                .id(facultyDTO.getId())
                .name(facultyDTO.getName())
                .build();

        Faculty save = facultyRepository.save(build);
        return responseMaker.updated(save);
    }

    public ResponseEntity<?> getAllRoom() {
        List<Faculty> all = facultyRepository.findAll();
        return responseMaker.success(all);
    }

    public ResponseEntity<?> remove(String id) {
        facultyRepository.removeById(id);
        return responseMaker.deleted();
    }
}
