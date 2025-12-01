package org.example.lms_room_allocating.common.app_constants;

public interface OpenApiConstants {
    String JSON_MEDIA_TYPE = "application/json";
    String SECURITY_SCHEME_NAME = "bearerAuth";
    String SUCCESS_SAMPLE = "{\"code\" : 200, \"status\" : \"Success\", \"Message\" : \"Success\"}";
    String BAD_REQUEST_SAMPLE = "{\"code\" : 400, \"status\" : \"Bad Request\", \"Message\" : \"Bad Request\"}";
    String UNAUTHORIZED_SAMPLE = "{\"code\" : 401, \"status\" : \"Unauthorized\", \"Message\" : \"Unauthorized\"}";
    String NOT_FOUND_SAMPLE = "{\"code\" : 404, \"status\" : \"Not Found\", \"Message\" : \"Not Found\"}";
    String INTERNAL_SERVER_ERROR_SAMPLE = "{\"code\" : 500, \"status\" : \"Internal Server Error\", \"Message\" : \"Internal Server Error\"}";
}
