package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.dto.AtlanticDto;
import com.emissions.industrialemissionsmap.dto.MaritimeDto;
import com.emissions.industrialemissionsmap.service.region.AtlanticService;
import com.emissions.industrialemissionsmap.service.region.MaritimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/region")
public class RegionController {

    private final AtlanticService atlanticService;
    private final MaritimeService maritimeService;

    public RegionController(AtlanticService atlanticService, MaritimeService maritimeService) {
        this.atlanticService = atlanticService;
        this.maritimeService = maritimeService;
    }

    //TODO Refactor to service
    @GetMapping("/maritime")
    public ResponseEntity<MaritimeDto> getMaritimes(@RequestParam int year) {
        MaritimeDto maritimeDto = maritimeService.getEmitters(year);
        return ResponseEntity.ok(maritimeDto);
    }

//    //TODO refactor to service
    @GetMapping("/atlantic")
    public ResponseEntity<AtlanticDto> getAtlantic(@RequestParam int year) {
        AtlanticDto atlanticDto = atlanticService.getEmitters(year);
        return ResponseEntity.ok(atlanticDto);
    }
}
