package org.example.lms_room_allocating.repository;

import org.example.lms_room_allocating.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, String> {
    void removeById(String id);
}
