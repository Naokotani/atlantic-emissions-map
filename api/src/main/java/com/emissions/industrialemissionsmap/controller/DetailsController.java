package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.dto.DetailsDto;
import com.emissions.industrialemissionsmap.mapper.DetailsMapper;
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
@RequestMapping("/api/v1/details")
public class DetailsController {
    private final EmitterRepository emitterRepository;
    private final DetailsMapper detailsMapper;

    public DetailsController(EmitterRepository emitterRepository, DetailsMapper detailsMapper) {
        this.emitterRepository = emitterRepository;
        this.detailsMapper = detailsMapper;
    }

    @GetMapping
    public ResponseEntity<DetailsDto> getDetails(@RequestParam int id) {
        Emitter emitter = emitterRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        DetailsDto detailsDto = detailsMapper.emitterToDetails(emitter);
        return ResponseEntity.ok(detailsDto);
    }
}
