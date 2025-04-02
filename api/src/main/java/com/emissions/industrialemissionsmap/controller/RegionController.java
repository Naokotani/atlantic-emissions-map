package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.dto.MaritimeDto;
import com.emissions.industrialemissionsmap.service.region.MaritimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/region")
public class RegionController {

    private final MaritimeService maritimeService;

    public RegionController(MaritimeService maritimeService) {
        this.maritimeService = maritimeService;
    }

    @GetMapping("/maritime")
    public ResponseEntity<MaritimeDto> getMaritimes(@RequestParam List<Integer> years) {
        MaritimeDto maritimeDto = maritimeService.getEmitters(years);
        return ResponseEntity.ok(maritimeDto);
    }
}
