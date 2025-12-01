package org.example.lms_room_allocating.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.example.lms_room_allocating.model.enums.WorkType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@SuperBuilder
public class Teacher extends BaseEntity {

    private String name;


    @ManyToMany
    @JoinTable(
            name = "teacher_lesson",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id")
    )
    private List<Lesson> lessons;

    @Enumerated(EnumType.STRING)
    private WorkType workType;

    @OneToOne(cascade = CascadeType.ALL)
    private WorkTime workTime;

    @Column(name = "worked_hours")
    private Float workedHours;

}
