package org.example.lms_room_allocating.repository;

import org.example.lms_room_allocating.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;

@Repository
public interface RoomRepository extends JpaRepository<Room, Spring> {

    void removeById(String id);
}
