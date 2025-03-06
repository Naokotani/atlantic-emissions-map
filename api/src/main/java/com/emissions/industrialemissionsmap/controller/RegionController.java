package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.dto.AtlanticDto;
import com.emissions.industrialemissionsmap.dto.MaritimeDto;
import com.emissions.industrialemissionsmap.service.region.AtlanticService;
import com.emissions.industrialemissionsmap.service.region.MaritimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/region")
public class RegionController {

    private final AtlanticService atlanticService;
    private final MaritimeService maritimeService;

    public RegionController(AtlanticService atlanticService, MaritimeService maritimeService) {
        this.atlanticService = atlanticService;
        this.maritimeService = maritimeService;
    }

    @GetMapping("/maritime")
    public ResponseEntity<MaritimeDto> getMaritimes(@RequestParam List<Integer> years) {
        MaritimeDto maritimeDto = maritimeService.getEmitters(years);
        return ResponseEntity.ok(maritimeDto);
    }

    @GetMapping("maritime/all")
    public ResponseEntity<MaritimeDto> getAllYearsMaritimes() {
        MaritimeDto maritimeDto = maritimeService.getEmittersAllYearsSum();
        return ResponseEntity.ok(maritimeDto);
    }

    @GetMapping("/atlantic")
    public ResponseEntity<AtlanticDto> getAtlantic(@RequestParam List<Integer> years ) {
        AtlanticDto atlanticDto = atlanticService.getEmitters(years);
        return ResponseEntity.ok(atlanticDto);
    }

    @GetMapping("atlantic/all")
    public ResponseEntity<AtlanticDto> getAllYearsAtlantic() {
        AtlanticDto atlanticDto = atlanticService.getEmittersAllYearsSum();
        return ResponseEntity.ok(atlanticDto);
    }
}
