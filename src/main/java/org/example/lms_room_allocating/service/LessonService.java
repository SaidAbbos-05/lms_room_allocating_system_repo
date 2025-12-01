package org.example.lms_room_allocating.service;


import org.example.lms_room_allocating.dtos.LessonDTO;
import org.example.lms_room_allocating.dtos.RoomDTO;
import org.example.lms_room_allocating.model.Lesson;
import org.example.lms_room_allocating.model.Room;
import org.example.lms_room_allocating.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;
    private final ResponseMaker responseMaker;

    @Autowired
    public LessonService(LessonRepository lessonRepository, ResponseMaker responseMaker) {
        this.lessonRepository = lessonRepository;
        this.responseMaker = responseMaker;
    }


    public ResponseEntity<?> create(LessonDTO lessonDTO) {
        Lesson build = Lesson.builder()
                .name(lessonDTO.getName())
                .description(lessonDTO.getDescription())
                .build();
        Lesson save = lessonRepository.save(build);
        return responseMaker.created(save);
    }

    public ResponseEntity<?> update(LessonDTO lessonDTO) {
        Lesson build = Lesson.builder()
                .id(lessonDTO.getId())
                .name(lessonDTO.getName())
                .description(lessonDTO.getDescription())
                .build();
        Lesson save = lessonRepository.save(build);
        return responseMaker.updated(save);
    }

    public ResponseEntity<?> getAllRoom() {
        List<Lesson> all = lessonRepository.findAll();
        return responseMaker.success(all);
    }

    public ResponseEntity<?> remove(String id) {
        lessonRepository.removeById(id);
        return responseMaker.deleted();
    }
}
