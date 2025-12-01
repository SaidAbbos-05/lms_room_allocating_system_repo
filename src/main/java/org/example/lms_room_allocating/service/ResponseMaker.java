package org.example.lms_room_allocating.service;

import org.example.lms_room_allocating.model.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ResponseMaker {

    public ResponseEntity<?> created(){
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> created(Object data){
        return ResponseEntity.status(201).body(data);
    }

    public ResponseEntity<?> updated(Object save) {
        return ResponseEntity.status(203).body(save);
    }


    public ResponseEntity<?> badRequest(){
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<?> badRequest(Object data, String message, Integer status){
        return ResponseEntity.badRequest().body(
                Map.of("message", message, "data", data, "status", status));
    }

    public ResponseEntity<?> notFound(){
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> notFound(Object data, String message, Integer status){
        return ResponseEntity.status(status).body(Map.of("message", message, "data", data, "status", status));
    }

    public ResponseEntity<?> success(Object data) {
        return ResponseEntity.status(200).body(data);
    }

    public ResponseEntity<?> deleted() {
        return ResponseEntity.ok().build();
    }
}
