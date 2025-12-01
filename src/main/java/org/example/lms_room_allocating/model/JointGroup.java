package org.example.lms_room_allocating.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.lms_room_allocating.model.enums.EducationType;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "joint_groups")
public class JointGroup extends BaseEntity {

    private String name;

    @Column(name = "student_count")
    private Integer studentCount;

    @Enumerated(value = EnumType.STRING)
    private EducationType educationType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;


    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "joint_groups_group",
            joinColumns = @JoinColumn(name = "joint_groups_id"),
            inverseJoinColumns = @JoinColumn(name = "groups_id")
    )
    private List<Group> groups;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
