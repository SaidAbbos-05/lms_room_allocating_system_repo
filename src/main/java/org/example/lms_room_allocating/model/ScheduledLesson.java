package org.example.lms_room_allocating.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@Entity(name = "scheduled_lesson")
public class ScheduledLesson extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "joint_group_id")
    private JointGroup jointGroup;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "day_of_week")
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek; // 1=Monday..7=Sunday

    @Column(name = "week_pattern")
    private String weekPattern; // e.g., "odd","even","every" or cron-like

    @Column(name = "status")
    private String status; // PLANNED, CONFIRMED, CANCELLED
}

