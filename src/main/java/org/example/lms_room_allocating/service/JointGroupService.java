package org.example.lms_room_allocating.service;

import org.example.lms_room_allocating.dtos.JointGroupDTO;
import org.example.lms_room_allocating.model.BaseEntity;
import org.example.lms_room_allocating.model.Group;
import org.example.lms_room_allocating.model.JointGroup;
import org.example.lms_room_allocating.model.Lesson;
import org.example.lms_room_allocating.model.Room;
import org.example.lms_room_allocating.model.Teacher;
import org.example.lms_room_allocating.repository.JointGroupRepository;
import org.hibernate.mapping.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JointGroupService {

    private final JointGroupRepository jointGroupRepository;
    private final ResponseMaker responseMaker;

    @Autowired
    public JointGroupService(JointGroupRepository jointGroupRepository, ResponseMaker responseMaker) {
        this.jointGroupRepository = jointGroupRepository;
        this.responseMaker = responseMaker;
    }

    public ResponseEntity<?> create(JointGroupDTO jointGroupDTO) {

        JointGroup jointGroup = jointGroupGenerator(jointGroupDTO);

        JointGroup save = jointGroupRepository.save(jointGroup);
        return responseMaker.created(save);
    }

    public ResponseEntity<?> update(JointGroupDTO jointGroupDTO) {
        JointGroup jointGroup = jointGroupGenerator(jointGroupDTO);

        JointGroup save = jointGroupRepository.save(jointGroup);
        return responseMaker.updated(save);
    }

    public ResponseEntity<?> getAllRoom() {
        List<JointGroup> all = jointGroupRepository.findAll();
        return responseMaker.success(all);
    }

    public ResponseEntity<?> remove(String id) {
        jointGroupRepository.removeById(id);
        return responseMaker.deleted();
    }

    private JointGroup jointGroupGenerator(JointGroupDTO jointGroupDTO) {
        List<Group> groups = jointGroupDTO.getGroups()
                .stream()
                .map(group ->
                        Group.builder().id(group.get("id")).build()).collect(Collectors.toList());
        Integer studentCount = groups.stream().map(Group::getStudentCount).reduce(0, Integer::sum);

        Room room = Room.builder()
                .id(jointGroupDTO.getRoomId())
                .build();
        Teacher teacher = Teacher.builder()
                .id(jointGroupDTO.getTeacherId())
                .build();
        Lesson lesson = Lesson.builder().id(jointGroupDTO.getLessonId()).build();

        return JointGroup.builder()
                .id(jointGroupDTO.getId())
                .name(jointGroupDTO.getName())
                .room(room)
                .teacher(teacher)
                .lesson(lesson)
                .studentCount(studentCount)
                .groups(groups).build();
    }
}
