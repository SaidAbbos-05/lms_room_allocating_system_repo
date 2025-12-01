package org.example.lms_room_allocating.service;

import org.example.lms_room_allocating.dtos.TeacherDTO;
import org.example.lms_room_allocating.model.Lesson;
import org.example.lms_room_allocating.model.Teacher;
import org.example.lms_room_allocating.repository.LessonRepository;
import org.example.lms_room_allocating.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final ResponseMaker responseMaker;
    private final LessonRepository lessonRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, ResponseMaker responseMaker, LessonRepository lessonRepository) {
        this.teacherRepository = teacherRepository;
        this.responseMaker = responseMaker;
        this.lessonRepository = lessonRepository;
    }

    public ResponseEntity<?> create(TeacherDTO teacherDTO) {

        var teacherLessons = lessonRepository.findAllById(teacherDTO.getSpecialityIds());

        Teacher build = Teacher.builder()
                .name(teacherDTO.getName())
                .lessons(teacherLessons)
                .build();

        Teacher save = teacherRepository.save(build);
        return responseMaker.created(save);
    }

    public ResponseEntity<?> update(TeacherDTO teacherDTO) {
        Teacher build = Teacher.builder()
                .id(teacherDTO.getId())
                .name(teacherDTO.getName())
//                .specialties(teacherDTO.getSpecialities())
                .build();
        Teacher save = teacherRepository.save(build);
        return responseMaker.updated(save);
    }

    public ResponseEntity<?> getAllRoom() {
        List<Teacher> all = teacherRepository.findAll();
        return responseMaker.success(all);
    }

    public ResponseEntity<?> remove(String id) {
        teacherRepository.removeById(id);
        return responseMaker.deleted();
    }
}
