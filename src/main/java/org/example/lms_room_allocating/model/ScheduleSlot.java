package org.example.lms_room_allocating.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleSlot {

    private JointGroup jointGroup;
    private Teacher teacher;
    private Room room;
    private Timestamp start;
    private Timestamp end;


    @Override
    public String toString() {
        return "📘 " + jointGroup.getName() + " | " + teacher.getName() + " | " + room.getName() +
               " (" + start + " - " + end + ")";
    }
}
