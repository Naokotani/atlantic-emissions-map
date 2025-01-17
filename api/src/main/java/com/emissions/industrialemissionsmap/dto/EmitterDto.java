package com.emissions.industrialemissionsmap.dto;

import lombok.Data;
import java.util.List;

@Data
public class EmitterDto {
    private int id;
    private String facilityName;
    private String facilityDescription;
    private double latitude;
    private double longitude;
    private double carbonDioxide;
    private double methane;
    private double nitrousOxide;
    private double sulphurHexaflouride;
    private double hydroflourocarbons;
    private double perfluorocarbons;
    private double totalEmissions;
}
