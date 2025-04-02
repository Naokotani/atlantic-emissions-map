package com.emissions.industrialemissionsmap.dto;

import lombok.Data;

@Data
public class AggregateEmitter {
    private String ghgrpId;
    private double latitude;
    private double longitude;
    private Double totalEmissionsTonnes;
    private Double carbonDioxide;
    private Double methane;
    private Double nitrousOxide;
    private Double sulphurHexaFlouride;
    private Double hydroflourocarbons;
    private Double perflourocarbons;
}
