package org.example.lms_room_allocating.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import org.example.lms_room_allocating.model.enums.RoomType;


import lombok.*;
import org.example.lms_room_allocating.model.enums.Speciality;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("capacity")
    private Integer capacity;

    @JsonProperty("roomType")
    private RoomType roomType;

    @JsonProperty("roomSpeciality")
    private Speciality roomSpeciality;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;

    @JsonProperty("updatedAt")
    private LocalDateTime updatedAt;

    @JsonProperty("modifiedBy")
    private String modifiedBy;
}
