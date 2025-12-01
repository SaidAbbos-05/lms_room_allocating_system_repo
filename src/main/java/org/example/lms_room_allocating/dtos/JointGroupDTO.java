package org.example.lms_room_allocating.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.lms_room_allocating.model.enums.EducationType;
import org.example.lms_room_allocating.model.enums.WorkType;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JointGroupDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("student_count")
    private Integer studentCount;

    @JsonProperty("educationType")
    private EducationType educationType;

    @JsonProperty("teacherId")
    private String teacherId;

    @JsonProperty("teacherName")
    private String teacherName;

    @JsonProperty("teacherWorkType")
    private WorkType teacherWorkType;


    @JsonProperty("lessonId")
    private String lessonId;

    @JsonProperty("lessonName")
    private String lessonName;


    @JsonProperty("groups")
    private List<Map<String, String>> groups; /// id name faculty bo'ladi.


    @JsonProperty("roomId")
    private String roomId;

    @JsonProperty("roomName")
    private String roomName;

    @JsonProperty("roomCappacity")
    private Integer roomCappacity;


}
