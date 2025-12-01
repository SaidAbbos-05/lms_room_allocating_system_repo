package org.example.lms_room_allocating.service;

import org.example.lms_room_allocating.dtos.RoomDTO;
import org.example.lms_room_allocating.model.Room;
import org.example.lms_room_allocating.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final ResponseMaker responseMaker;

    @Autowired
    public RoomService(RoomRepository roomRepository, ResponseMaker responseMaker) {
        this.roomRepository = roomRepository;
        this.responseMaker = responseMaker;
    }

    public ResponseEntity<?> create(RoomDTO roomDTO) {
        Room build = Room.builder()
                .name(roomDTO.getName())
                .capacity(roomDTO.getCapacity())
                .type(roomDTO.getRoomType())
                .speciality(roomDTO.getRoomSpeciality())
                .build();
        Room save = roomRepository.save(build);
        return responseMaker.created(save);
    }

    public ResponseEntity<?> update(RoomDTO roomDTO) {
        Room build = Room.builder()
                .id(roomDTO.getId())
                .name(roomDTO.getName())
                .capacity(roomDTO.getCapacity())
                .type(roomDTO.getRoomType())
                .speciality(roomDTO.getRoomSpeciality())
                .build();
        Room save = roomRepository.save(build);
        return responseMaker.updated(save);
    }

    public ResponseEntity<?> getAllRoom() {
        List<Room> all = roomRepository.findAll();
        return responseMaker.success(all);
    }

    public ResponseEntity<?> remove(String id) {
        roomRepository.removeById(id);
        return responseMaker.deleted();
    }
}
