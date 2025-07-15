package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.dto.EmitterDto;
import com.emissions.industrialemissionsmap.mapper.EmitterMapper;
import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.repository.EmitterRepository;
import com.emissions.industrialemissionsmap.service.DataSetService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emitter")
public class EmitterController {

    private final EmitterRepository emitterRepository;
    private final EmitterMapper emitterMapper;
    private final DataSetService dataSetService;

    public EmitterController(EmitterRepository emitterRepository, EmitterMapper emitterMapper, DataSetService dataSetService) {
        this.emitterRepository = emitterRepository;
        this.emitterMapper = emitterMapper;
        this.dataSetService = dataSetService;
    }

    @Operation(summary = "Get a single emitter by id")
    @GetMapping("/id")
    public ResponseEntity<EmitterDto> emitterByIdAndYear(@RequestParam int id)
    throws ResponseStatusException {
        Emitter emitter =  emitterRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        EmitterDto emitterDto = emitterMapper.emitterToEmitterDto(emitter);
        return ResponseEntity.ok(emitterDto);
    }

    @Operation(summary = "Get all years by busines number")
    @GetMapping("/bussiness-number")
    public ResponseEntity<List<EmitterDto>> emitterBussinessId(@RequestParam int number)
            throws ResponseStatusException {
        List<Emitter> emitters = emitterRepository.findEmittersByReportingCompanyBusinessNumberAndDataSet(number, dataSetService.findActiveDataSet())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<EmitterDto> emitterDtos = emitters.stream().map(emitterMapper::emitterToEmitterDto).toList();
        return ResponseEntity.ok(emitterDtos);
    }

    @Operation(summary = "Get a single emitter by name and year")
    @GetMapping("/name")
    public ResponseEntity<EmitterDto> emitterByNameAndYear(@RequestParam int year, @RequestParam String name)
            throws ResponseStatusException {
        Emitter emitter =  emitterRepository.findEmitterByFacilityNameAndYearAndDataSet(name, year,
                        dataSetService.findActiveDataSet())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        EmitterDto emitterDto = emitterMapper.emitterToEmitterDto(emitter);
        return ResponseEntity.ok(emitterDto);
    }

    @Operation(summary = "Get all years by facility name")
    @GetMapping("/facility-name")
    public ResponseEntity<List<EmitterDto>> emitterAllYearsByFacilityName(@RequestParam String name)
            throws ResponseStatusException {
        List<Emitter> emitters = emitterRepository.findAllByFacilityNameAndDataSet(name, dataSetService.findActiveDataSet())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<EmitterDto> emitterDtos = emitters.stream().map(emitterMapper::emitterToEmitterDto).toList();
        return ResponseEntity.ok(emitterDtos);
    }
}



