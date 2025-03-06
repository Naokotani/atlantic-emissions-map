package com.emissions.industrialemissionsmap.model;

import lombok.Data;

@Data
public class AggregateEmitter {
        private String facilityName;
        private String facilityDescriptionEnglish;
        private String reportingCompanyBusinessNumber;
        private String facilityProvinceTerritory;
        private Double latitude;
        private Double longitude;
        private Double totalEmissionsTonnes;
        private Double co2Tonnes;
        private Double ch4Co2TonnesEquivalent;
        private Double n2oCo2TonnesEquivalent;
        private Double sf6Co2TonnesEquivalent;
        private Double pfcTotalCo2Tonnes;
        private Double hfc32Co2TonnesEquivalent;
        private Double hfc41Co2TonnesEquivalent;
        private Double hfc4310meeCo2TonnesEquivalent;
        private Double hfc125Co2TonnesEquivalent;
        private Double hfc134Co2TonnesEquivalent;
        private Double hfc134aCo2TonnesEquivalent;
        private Double hfc143Co2TonnesEquivalent;
        private Double hfc143aCo2TonnesEquivalent;
        private Double hfc152aCo2TonnesEquivalent;
        private Double hfc227eaCo2TonnesEquivalent;
        private Double hfc236faCo2TonnesEquivalent;
        private Double hfc245caCo2TonnesEquivalent;
}
