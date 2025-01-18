package com.emissions.industrialemissionsmap.dto;

import lombok.Data;

@Data
public class EmitterDto {
    private int id;
    private int year;
    private String facilityName;
    private String facilityDescription;
    private int businessNumber;
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
