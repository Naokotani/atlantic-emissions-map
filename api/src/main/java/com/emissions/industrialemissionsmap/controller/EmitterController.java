package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.dto.EmitterDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/emitter")
public class EmitterController {

    //TODO map emitter
    @GetMapping
    public ResponseEntity<EmitterDto> emitter(@RequestParam int id) {
        EmitterDto emitter = new EmitterDto();
        return ResponseEntity.ok(emitter);
    }
}
