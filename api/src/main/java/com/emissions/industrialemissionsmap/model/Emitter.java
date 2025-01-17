package com.emissions.industrialemissionsmap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Emitter {
    @Id
    @GeneratedValue
    private Integer id;
    private int year;
    private String facilityName;
    private String facilityLocation;
    private String facilityCityOrDistrict;
    private String facilityProvinceTerritory;
    private String facilityPostalCode;
    private String latitude;
    private String longitude;
    private String facilityDescriptionEnglish;
    private String facilityDescriptionFrench;
    private String reportingCompanyLegalName;
    private String reportingCompanyTradeName;
    private String reportingCompanyBusinessNumber;
    private String publicContactName;
    private String publicContactPosition;
    private String publicContactTelephone;
    private String publicContactExtension;
    private String publicContactEmail;
    private String publicContactMailingAddress;
    private String publicContactCityOrDistrict;
    private String publicContactPostalCode;
    private double co2Tonnes;
    private double ch4Tonnes;
    private double ch4Co2TonnesEquivalent;
    private double n2oTonnes;
    private double n2oCo2TonnesEquivalent;
    private double hfc23Tonnes;
    private double hfc23Co2TonnesEquivalent;
    private double hfc32Tonnes;
    private double hfc32Co2TonnesEquivalent;
    private double hfc41Tonnes;
    private double hfc41Co2TonnesEquivalent;
    private double hfc4310meeTonnes;
    private double hfc4310meeCo2TonnesEquivalent;
    private double hfc125Tonnes;
    private double hfc125Co2TonnesEquivalent;
    private double hfc134Tonnes;
    private double hfc134Co2TonnesEquivalent;
    private double hfc134aTonnes;
    private double hfc134aCo2TonnesEquivalent;
    private double hfc143Tonnes;
    private double hfc143Co2TonnesEquivalent;
    private double hfc143aTonnes;
    private double hfc143aCo2TonnesEquivalent;
    private double hfc152aTonnes;
    private double hfc152aCo2TonnesEquivalent;
    private double hfc227eaTonnes;
    private double hfc227eaCo2TonnesEquivalent;
    private double hfc236faTonnes;
    private double hfc236faCo2TonnesEquivalent;
    private double hfc245caTonnes;
    private double hfc245caCo2TonnesEquivalent;
    private double cf4Tonnes;
    private double cf4Co2TonnesEquivalent;
    private double c2f6Tonnes;
    private double c2f6Co2TonnesEquivalent;
    private double c3f8Tonnes;
    private double c3f8Co2TonnesEquivalent;
    private double c4f10Tonnes;
    private double c4f10Co2TonnesEquivalent;
    private double c4f8Tonnes;
    private double c4f8Co2TonnesEquivalent;
    private double c5F12Tonnes;
    private double c5F12Co2TonnesEquivalent;
    private double c6F14Tonnes;
    private double c6F14Co2TonnesEquivalent;
    private double pfcTotalCo2Tonnes;
    private double sf6Tonnes;
    private double sf6Co2TonnesEquivalent;
    private double totalEmissionsTonnes;
}
