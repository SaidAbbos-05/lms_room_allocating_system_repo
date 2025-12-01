package org.example.lms_room_allocating.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.lms_room_allocating.model.JointGroup;
import org.example.lms_room_allocating.model.ScheduleSlot;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleGeneratorResult {

    @JsonProperty("scheduled")
    public List<ScheduleSlot> scheduled;

    @JsonProperty("unscheduled")
    public List<JointGroup> unscheduled;
}
