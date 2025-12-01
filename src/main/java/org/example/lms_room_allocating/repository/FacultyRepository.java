package org.example.lms_room_allocating.repository;


import org.example.lms_room_allocating.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String> {
    void removeById(String id);
}
