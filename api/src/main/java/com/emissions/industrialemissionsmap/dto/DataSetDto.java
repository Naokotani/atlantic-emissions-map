package com.emissions.industrialemissionsmap.dto;

import com.emissions.industrialemissionsmap.model.Emitter;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class DataSetDto {
    private int currentYear;
    private boolean active;
    private int records;
    private LocalDateTime uploaded;
    private Set<Integer> years;
}
