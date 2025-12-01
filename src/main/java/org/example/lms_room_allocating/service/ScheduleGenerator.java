package org.example.lms_room_allocating.service;

import org.example.lms_room_allocating.dtos.ScheduleGeneratorResult;
import org.example.lms_room_allocating.model.JointGroup;
import org.example.lms_room_allocating.model.Room;
import org.example.lms_room_allocating.model.ScheduleSlot;
import org.example.lms_room_allocating.model.Teacher;
import org.example.lms_room_allocating.model.WorkTime;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScheduleGenerator {


    public ScheduleGeneratorResult generateSchedule(
            List<JointGroup> jointGroups,
            List<Room> rooms,
            List<Teacher> teachers
    ) {
        var result = new ScheduleGeneratorResult();

        // 1. Teacher, Group va Room ma’lumotlarini tozalaymiz
        Map<String, List<ScheduleSlot>> teacherSchedule = new HashMap<>();
        Map<String, List<ScheduleSlot>> roomSchedule = new HashMap<>();

        // 2. Guruhlarni ta’lim turiga qarab ajratamiz
        jointGroups.sort(Comparator.comparing(jg ->
                jg.getEducationType().toString()));

        // 3. Har bir jointGroup uchun joy topamiz
        for (JointGroup group : jointGroups) {
            Teacher teacher = group.getTeacher();

            if (teacher == null || teacher.getWorkTime() == null) {
                result.unscheduled.add(group);
                continue;
            }

            // Ish vaqtini olamiz
            WorkTime wt = teacher.getWorkTime();
            Timestamp start = wt.getStartTime();
            Timestamp end = wt.getEndTime();

            // Xonalarni filterlaymiz
            List<Room> suitableRooms = rooms.stream()
                    .filter(r -> r.getCapacity() >= group.getStudentCount() - 2) // 2ta farq mayli deding
                    .toList();

            if (suitableRooms.isEmpty()) {
                result.unscheduled.add(group);
                continue;
            }

            boolean scheduled = false;

            for (Room room : suitableRooms) {
                // Tekshiramiz: bu vaqtda bu xona band emasmi?
                boolean roomBusy = roomSchedule
                        .getOrDefault(room.getId(), new ArrayList<>())
                        .stream()
                        .anyMatch(s -> timesOverlap(s.getStart(), s.getEnd(), start, end));

                // Tekshiramiz: o‘qituvchi band emasmi?
                boolean teacherBusy = teacherSchedule
                        .getOrDefault(teacher.getId(), new ArrayList<>())
                        .stream()
                        .anyMatch(s -> timesOverlap(s.getStart(), s.getEnd(), start, end));

                if (!roomBusy && !teacherBusy) {
                    ScheduleSlot slot = new ScheduleSlot(group, teacher, room, start, end);

                    teacherSchedule.computeIfAbsent(teacher.getId(), k -> new ArrayList<>()).add(slot);
                    roomSchedule.computeIfAbsent(room.getId(), k -> new ArrayList<>()).add(slot);

                    result.scheduled.add(slot);
                    scheduled = true;
                    break;
                }
            }

            if (!scheduled) {
                result.unscheduled.add(group);
            }
        }

        return result;
    }

    private boolean timesOverlap(Timestamp s1, Timestamp e1, Timestamp s2, Timestamp e2) {
        return !(e1.before(s2) || e2.before(s1));
    }

}
