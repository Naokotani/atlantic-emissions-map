package com.emissions.industrialemissionsmap.dto;

import lombok.Data;
import java.util.List;

@Data
public class EmitterDto {
    private int id;
    private String businessName;
    private String facilityDescription;
    private float latitude;
    private float longitude;
    private List<GasDto> gasses;
    private float totalEmissions;
}
