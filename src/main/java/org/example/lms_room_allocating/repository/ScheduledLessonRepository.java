package org.example.lms_room_allocating.repository;

import org.example.lms_room_allocating.model.Room;
import org.example.lms_room_allocating.model.ScheduledLesson;
import org.example.lms_room_allocating.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Repository
public interface ScheduledLessonRepository extends JpaRepository<ScheduledLesson, String> {

    @Query("""
                SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END
                FROM scheduled_lesson s
                WHERE s.teacher = :teacher
                  AND s.dayOfWeek = :dayOfWeek
                  AND (s.startTime < :end AND s.endTime > :start)
            """)
    boolean existsByTeacherAndDayOfWeek(
            @Param("teacher") Teacher teacher,
            @Param("dayOfWeek") DayOfWeek dayOfWeek,
            @Param("start") LocalTime start,
            @Param("end") LocalTime end
    );



    @Query("""
            SELECT CASE WHEN COUNT(s) > 0
            THEN true ELSE false END
            FROM scheduled_lesson s
            WHERE s.room = :room
            AND s.dayOfWeek = :dayOfWeek
            AND ((s.startTime < :end AND s.endTime > :start))
            """)
    boolean existsByRoomAndDayOfWeek(
            @Param("room") Room room,
            @Param("dayOfWeek") DayOfWeek dayOfWeek,
            @Param("start") LocalTime start,
            @Param("end") LocalTime end
    );
}

