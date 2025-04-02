package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.dto.DetailsDto;
import com.emissions.industrialemissionsmap.mapper.DetailsMapper;
import com.emissions.industrialemissionsmap.model.DataSet;
import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.repository.EmitterRepository;
import com.emissions.industrialemissionsmap.service.DataSetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/details")
public class DetailsController {
    private final EmitterRepository emitterRepository;
    private final DetailsMapper detailsMapper;
    private final DataSetService dataSetService;

    public DetailsController(EmitterRepository emitterRepository, DetailsMapper detailsMapper, DataSetService dataSetService) {
        this.emitterRepository = emitterRepository;
        this.detailsMapper = detailsMapper;
        this.dataSetService = dataSetService;
    }

    @GetMapping
    public ResponseEntity<DetailsDto> getDetailsByGhgrpId(@RequestParam String ghgrpId) {
        DataSet activeDataSet = dataSetService.findActiveDataSet();
        List<Emitter> emitters = emitterRepository.findEmitterByGhgrpIdAndDataSet(ghgrpId, activeDataSet)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        int currentYear = emitters.stream().map(Emitter::getYear).max(Integer::compareTo).orElseThrow();
        Emitter emitter = emitters.stream().filter(e -> e.getYear() == currentYear).findFirst().orElseThrow();
        DetailsDto detailsDto = detailsMapper.emitterToDetails(emitter);
        return ResponseEntity.ok(detailsDto);
    }
}
