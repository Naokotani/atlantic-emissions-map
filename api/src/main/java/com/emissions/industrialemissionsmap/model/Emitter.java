package com.emissions.industrialemissionsmap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Emitter {
    @Id
    @GeneratedValue
    private Integer id;
    private String ghgrpId;
    private int year;
    private String facilityName;
    private String facilityLocation;
    private String facilityCityOrDistrict;
    private String facilityProvinceOrTerritory;
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
    private String co2Tonnes;
    private String ch4Tonnes;
    private String ch4Co2TonnesEquivalent;
    private String n2oTonnes;
    private String n2oCo2TonnesEquivalent;
    private String hfc23Tonnes;
    private String hfc23Co2TonnesEquivalent;
    private String hfc32Tonnes;
    private String hfc32Co2TonnesEquivalent;
    private String hfc41Tonnes;
    private String hfc41Co2TonnesEquivalent;
    private String hfc4310meeTonnes;
    private String hfc4310meeCo2TonnesEquivalent;
    private String hfc125Tonnes;
    private String hfc125Co2TonnesEquivalent;
    private String hfc134Tonnes;
    private String hfc134Co2TonnesEquivalent;
    private String hfc134aTonnes;
    private String hfc134aCo2TonnesEquivalent;
    private String hfc143Tonnes;
    private String hfc143Co2TonnesEquivalent;
    private String hfc143aTonnes;
    private String hfc143aCo2TonnesEquivalent;
    private String hfc152aTonnes;
    private String hfc152aCo2TonnesEquivalent;
    private String hfc227eaTonnes;
    private String hfc227eaCo2TonnesEquivalent;
    private String hfc236faTonnes;
    private String hfc236faCo2TonnesEquivalent;
    private String hfc245caTonnes;
    private String hfc245caCo2TonnesEquivalent;
    private String cf4Tonnes;
    private String cf4Co2TonnesEquivalent;
    private String c2f6Tonnes;
    private String c2f6Co2TonnesEquivalent;
    private String c3f8Tonnes;
    private String c3f8Co2TonnesEquivalent;
    private String c4f10Tonnes;
    private String c4f10Co2TonnesEquivalent;
    private String c4f8Tonnes;
    private String c4f8Co2TonnesEquivalent;
    private String c5F12Tonnes;
    private String c5F12Co2TonnesEquivalent;
    private String c6F14Tonnes;
    private String c6F14Co2TonnesEquivalent;
    private String pfcTotalCo2Tonnes;
    private String sf6Tonnes;
    private String sf6Co2TonnesEquivalent;
    private String totalEmissionsTonnes;

    public Emitter(String ghgrpId,
                   int year,
                   String facilityName,
                   String facilityLocation,
                   String facilityCityOrDistrict,
                   String facilityProvinceOrTerritory,
                   String facilityPostalCode,
                   String latitude,
                   String longitude,
                   String facilityDescriptionEnglish,
                   String facilityDescriptionFrench,
                   String reportingCompanyLegalName,
                   String reportingCompanyTradeName,
                   String reportingCompanyBusinessNumber,
                   String publicContactName,
                   String publicContactPosition,
                   String publicContactTelephone,
                   String publicContactExtension,
                   String publicContactEmail,
                   String publicContactMailingAddress,
                   String publicContactCityOrDistrict,
                   String publicContactPostalCode,
                   String co2Tonnes,
                   String ch4Tonnes,
                   String ch4Co2TonnesEquivalent,
                   String n2oTonnes,
                   String n2oCo2TonnesEquivalent,
                   String hfc23Tonnes,
                   String hfc23Co2TonnesEquivalent,
                   String hfc32Tonnes,
                   String hfc32Co2TonnesEquivalent,
                   String hfc41Tonnes,
                   String hfc41Co2TonnesEquivalent,
                   String hfc4310meeTonnes,
                   String hfc4310meeCo2TonnesEquivalent,
                   String hfc125Tonnes,
                   String hfc125Co2TonnesEquivalent,
                   String hfc134Tonnes,
                   String hfc134Co2TonnesEquivalent,
                   String hfc134aTonnes,
                   String hfc134aCo2TonnesEquivalent,
                   String hfc143Tonnes,
                   String hfc143Co2TonnesEquivalent,
                   String hfc143aTonnes,
                   String hfc143aCo2TonnesEquivalent,
                   String hfc152aTonnes,
                   String hfc152aCo2TonnesEquivalent,
                   String hfc227eaTonnes,
                   String hfc227eaCo2TonnesEquivalent,
                   String hfc236faTonnes,
                   String hfc236faCo2TonnesEquivalent,
                   String hfc245caTonnes,
                   String hfc245caCo2TonnesEquivalent,
                   String cf4Tonnes,
                   String cf4Co2TonnesEquivalent,
                   String c2f6Tonnes,
                   String c2f6Co2TonnesEquivalent,
                   String c3f8Tonnes,
                   String c3f8Co2TonnesEquivalent,
                   String c4f10Tonnes,
                   String c4f10Co2TonnesEquivalent,
                   String c4f8Tonnes,
                   String c4f8Co2TonnesEquivalent,
                   String c5F12Tonnes,
                   String c5F12Co2TonnesEquivalent,
                   String c6F14Tonnes,
                   String c6F14Co2TonnesEquivalent,
                   String pfcTotalCo2Tonnes,
                   String sf6Tonnes,
                   String sf6Co2TonnesEquivalent,
                   String totalEmissionsTonnes
        ) {
        this.ghgrpId = ghgrpId;
        this.year = year;
        this.facilityName = facilityName;
        this.facilityLocation = facilityLocation;
        this.facilityCityOrDistrict = facilityCityOrDistrict;
        this.facilityProvinceOrTerritory = facilityProvinceOrTerritory;
        this.facilityPostalCode = facilityPostalCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.facilityDescriptionEnglish = facilityDescriptionEnglish;
        this.facilityDescriptionFrench = facilityDescriptionFrench;
        this.reportingCompanyLegalName = reportingCompanyLegalName;
        this.reportingCompanyTradeName = reportingCompanyTradeName;
        this.reportingCompanyBusinessNumber = reportingCompanyBusinessNumber;
        this.publicContactName = publicContactName;
        this.publicContactPosition = publicContactPosition;
        this.publicContactTelephone = publicContactTelephone;
        this.publicContactExtension = publicContactExtension;
        this.publicContactEmail = publicContactEmail;
        this.publicContactMailingAddress = publicContactMailingAddress;
        this.publicContactCityOrDistrict = publicContactCityOrDistrict;
        this.publicContactPostalCode = publicContactPostalCode;
        this.co2Tonnes = co2Tonnes;
        this.ch4Tonnes = ch4Tonnes;
        this.ch4Co2TonnesEquivalent = ch4Co2TonnesEquivalent;
        this.n2oTonnes = n2oTonnes;
        this.n2oCo2TonnesEquivalent = n2oCo2TonnesEquivalent;
        this.hfc23Tonnes = hfc23Tonnes;
        this.hfc23Co2TonnesEquivalent  = hfc23Co2TonnesEquivalent;
        this.hfc32Tonnes = hfc32Tonnes;
        this.hfc32Co2TonnesEquivalent = hfc32Co2TonnesEquivalent;
        this.hfc41Tonnes = hfc41Tonnes;
        this.hfc41Co2TonnesEquivalent = hfc41Co2TonnesEquivalent;
        this.hfc4310meeTonnes = hfc4310meeTonnes;
        this.hfc4310meeCo2TonnesEquivalent = hfc4310meeCo2TonnesEquivalent;
        this.hfc125Tonnes = hfc125Tonnes;
        this.hfc125Co2TonnesEquivalent = hfc125Co2TonnesEquivalent;
        this.hfc134Tonnes = hfc134Tonnes;
        this.hfc134Co2TonnesEquivalent = hfc134Co2TonnesEquivalent;
        this.hfc134aTonnes = hfc134aTonnes;
        this.hfc134aCo2TonnesEquivalent = hfc134aCo2TonnesEquivalent;
        this.hfc143Tonnes = hfc143Tonnes;
        this.hfc143Co2TonnesEquivalent = hfc143Co2TonnesEquivalent;
        this.hfc143aTonnes = hfc143aTonnes;
        this.hfc143aCo2TonnesEquivalent = hfc143aCo2TonnesEquivalent;
        this.hfc152aTonnes = hfc152aTonnes;
        this.hfc152aCo2TonnesEquivalent = hfc152aCo2TonnesEquivalent;
        this.hfc227eaTonnes = hfc227eaTonnes;
        this.hfc227eaCo2TonnesEquivalent = hfc227eaCo2TonnesEquivalent;
        this.hfc236faTonnes = hfc236faTonnes;
        this.hfc236faCo2TonnesEquivalent = hfc236faCo2TonnesEquivalent;
        this.hfc245caTonnes = hfc245caTonnes;
        this.hfc245caCo2TonnesEquivalent = hfc245caCo2TonnesEquivalent;
        this.cf4Tonnes = cf4Tonnes;
        this.cf4Co2TonnesEquivalent = cf4Co2TonnesEquivalent;
        this.c2f6Tonnes = c2f6Tonnes;
        this.c2f6Co2TonnesEquivalent = c2f6Co2TonnesEquivalent;
        this.c3f8Tonnes = c3f8Tonnes;
        this.c3f8Co2TonnesEquivalent = c3f8Co2TonnesEquivalent;
        this.c4f10Tonnes = c4f10Tonnes;
        this.c4f10Co2TonnesEquivalent = c4f10Co2TonnesEquivalent;
        this.c4f8Tonnes = c4f8Tonnes;
        this.c4f8Co2TonnesEquivalent = c4f8Co2TonnesEquivalent;
        this.c5F12Tonnes = c5F12Tonnes;
        this.c5F12Co2TonnesEquivalent = c5F12Co2TonnesEquivalent;
        this.c6F14Tonnes = c6F14Tonnes;
        this.c6F14Co2TonnesEquivalent = c6F14Co2TonnesEquivalent;
        this.pfcTotalCo2Tonnes = pfcTotalCo2Tonnes;
        this.sf6Tonnes = sf6Tonnes;
        this.sf6Co2TonnesEquivalent = sf6Co2TonnesEquivalent;
        this.totalEmissionsTonnes = totalEmissionsTonnes;
    }
}
