package org.example.lms_room_allocating.repository;

import org.example.lms_room_allocating.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {


    void removeById(String id);
}
