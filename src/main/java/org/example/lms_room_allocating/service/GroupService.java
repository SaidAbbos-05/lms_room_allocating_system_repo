package org.example.lms_room_allocating.service;

import org.example.lms_room_allocating.dtos.GroupDTO;
import org.example.lms_room_allocating.model.Faculty;
import org.example.lms_room_allocating.model.Group;
import org.example.lms_room_allocating.model.JointGroup;
import org.example.lms_room_allocating.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final ResponseMaker responseMaker;

    @Autowired
    public GroupService(GroupRepository groupRepository, ResponseMaker responseMaker) {
        this.groupRepository = groupRepository;
        this.responseMaker = responseMaker;
    }

    public ResponseEntity<?> create(GroupDTO groupDTO) {
        Group group = generateGroupEntity(groupDTO);
        return responseMaker.created(group);
    }

    public ResponseEntity<?> update(GroupDTO groupDTO) {
        Group group = generateGroupEntity(groupDTO);
        return responseMaker.updated(group);
    }

    public ResponseEntity<?> getAllGroup() {
        List<Group> all = groupRepository.findAll();
        return responseMaker.success(all);
    }

    public ResponseEntity<?> remove(String id) {
        groupRepository.removeById(id);
        return responseMaker.deleted();
    }

    private Group generateGroupEntity(GroupDTO groupDTO) {
        List<JointGroup> jointGroups = groupDTO.getJointGroups()
                .stream()
                .map(group ->
                        JointGroup.builder().id(group.get("id")).build())
                .collect(Collectors.toList());

        return Group.builder()
                .name(groupDTO.getName())
                .faculty(Faculty.builder().id(groupDTO.getFacultyId()).build())
                .joinGroups(jointGroups)
                .build();
    }
}
