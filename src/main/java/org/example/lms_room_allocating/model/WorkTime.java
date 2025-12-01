package org.example.lms_room_allocating.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@RequiredArgsConstructor
@Getter
@Setter
@Entity(name = "work_time")
public class WorkTime extends BaseEntity {

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

}
