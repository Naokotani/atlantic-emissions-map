package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.dto.EmitterDto;
import com.emissions.industrialemissionsmap.mapper.EmitterMapper;
import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.repository.EmitterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/emitter")
public class EmitterController {

    private final EmitterRepository emitterRepository;
    private final EmitterMapper emitterMapper;

    public EmitterController(EmitterRepository emitterRepository, EmitterMapper emitterMapper) {
        this.emitterRepository = emitterRepository;
        this.emitterMapper = emitterMapper;
    }

    @GetMapping("/name")
    public ResponseEntity<EmitterDto> emitterByNameAndYear(@RequestParam int year, @RequestParam String name)
    throws ResponseStatusException {
        Emitter emitter =  emitterRepository.findEmitterByFacilityNameAndYear(name, year)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        EmitterDto emitterDto = emitterMapper.emitterToEmitterDto(emitter);
        return ResponseEntity.ok(emitterDto);
    }

    @GetMapping("/id")
    public ResponseEntity<EmitterDto> emitterByIdAndYear(@RequestParam int year, @RequestParam int id)
    throws ResponseStatusException {
        Emitter emitter =  emitterRepository.findEmitterByIdAndYear(id, year)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        EmitterDto emitterDto = emitterMapper.emitterToEmitterDto(emitter);
        return ResponseEntity.ok(emitterDto);
    }
}



