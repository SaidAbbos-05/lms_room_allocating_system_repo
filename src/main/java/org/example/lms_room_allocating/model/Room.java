package org.example.lms_room_allocating.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.lms_room_allocating.model.enums.RoomType;
import org.example.lms_room_allocating.model.enums.Speciality;

@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
@Entity(name = "room")
public class Room extends BaseEntity{

    private String name;

    private Integer capacity;

    @Column(name = "room_type")
    @Enumerated(EnumType.STRING)
    private RoomType type;

    @Column(name = "room_speciality")
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
}
