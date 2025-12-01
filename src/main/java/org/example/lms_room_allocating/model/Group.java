package org.example.lms_room_allocating.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "groups")
public class Group  extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @Column(name = "student_count")
    private Integer studentCount;

    @ManyToMany(mappedBy = "groups")
    private List<JointGroup> joinGroups;


}
