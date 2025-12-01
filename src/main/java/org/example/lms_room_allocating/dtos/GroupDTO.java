package org.example.lms_room_allocating.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class GroupDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("facultyId")
    private String facultyId;

    @JsonProperty("facultyName")
    private String facultyName;

    @JsonProperty("studentCount")
    private Integer studentCount;

    @JsonProperty("jointGroups")
    private List<Map<String,String>> jointGroups;

}
