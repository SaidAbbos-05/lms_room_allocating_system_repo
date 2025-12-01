package org.example.lms_room_allocating.common.config;

import org.springframework.stereotype.Component;

@Component
public class OpenApiProperties extends PropertyReader{

    public OpenApiProperties() {
        super("external/openapi.properties");
    }

}
