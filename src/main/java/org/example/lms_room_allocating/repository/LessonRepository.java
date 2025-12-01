package org.example.lms_room_allocating.repository;

import org.example.lms_room_allocating.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, String> {
    void removeById(String id);
}
