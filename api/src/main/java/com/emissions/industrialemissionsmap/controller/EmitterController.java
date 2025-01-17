package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.dto.EmitterDto;
import com.emissions.industrialemissionsmap.mapper.EmitterMapper;
import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.repository.EmitterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/emitter")
public class EmitterController {

    private final EmitterRepository emitterRepository;
    private final EmitterMapper emitterMapper;

    public EmitterController(EmitterRepository emitterRepository, EmitterMapper emitterMapper) {
        this.emitterRepository = emitterRepository;
        this.emitterMapper = emitterMapper;
    }

    @GetMapping("/id")
    public ResponseEntity<EmitterDto> emitterById(@RequestParam int id, @RequestParam String name) {
        //TODO error handle
        Emitter emitter =  emitterRepository.findById(id).orElseThrow();
        EmitterDto emitterDto = emitterMapper.emitterToEmitterDto(emitter);
        return ResponseEntity.ok(emitterDto);
    }


    @GetMapping("/name")
    public ResponseEntity<EmitterDto> emitterByName(@RequestParam String name, @RequestParam int year) {
        EmitterDto emitter = new EmitterDto();
        emitter.setId(1);
        return ResponseEntity.ok(emitter);
    }
}



