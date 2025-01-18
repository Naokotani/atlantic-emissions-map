package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.dto.DetailsDto;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/details")
public class DetailsController {

    @GetMapping
    public ResponseEntity<DetailsDto> getDetails(@RequestParam int id) {
        DetailsDto detailsDto = new DetailsDto();
        return ResponseEntity.ok(detailsDto);
    }
}
