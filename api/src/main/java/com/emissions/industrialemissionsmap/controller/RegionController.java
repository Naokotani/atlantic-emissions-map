package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.dto.RegionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.plaf.synth.Region;

@RestController
@RequestMapping("/api/v1/region")
public class RegionController {

    @GetMapping
    public ResponseEntity<RegionDto> getRegion() {
        RegionDto regionDto = new RegionDto();
        return ResponseEntity.ok(regionDto);
    }
}
