package org.example.lms_room_allocating.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.lms_room_allocating.model.enums.Speciality;

import java.util.List;

@SuperBuilder
@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Lesson extends BaseEntity{

    private String name;

    private Speciality speciality;

    private String description;

    @OneToMany(mappedBy = "lesson")
    private List<JointGroup> jointGroups;

    @ManyToMany(mappedBy = "lessons")
    private List<Teacher> teachers;
}
