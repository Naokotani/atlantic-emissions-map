package com.emissions.industrialemissionsmap.dto;

import lombok.Data;

@Data
public class GasDto {
    private String name;
    private float tonnes;
    private float co2EquivalentTonnes;
}
