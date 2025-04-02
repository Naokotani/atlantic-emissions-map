package com.emissions.industrialemissionsmap.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmitterCsvRepresentation {
    @CsvBindByName(column = "GHGRP ID No. / No d'identification du PDGES")
    private String ghgrpId;
    @CsvBindByName(column = "Reference Year / Année de référence")
    private int year;
    @CsvBindByName(column = "Facility Name / Nom de l'installation")
    private String facilityName;
    @CsvBindByName(column = "Facility Location / Emplacement de l'installation")
    private String facilityLocation;
    @CsvBindByName(column = "Facility City or District or Municipality / Ville ou District ou Municipalité de l'installation")
    private String facilityCityOrDistrict;
    @CsvBindByName(column = "Facility Province or Territory / Province ou territoire de l'installation")
    private String facilityProvinceTerritory;
    @CsvBindByName(column = "Facility Postal Code / Code postal de l'installation")
    private String facilityPostalCode;
    @CsvBindByName(column = "Latitude")
    private double latitude;
    @CsvBindByName(column = "Longitude")
    private double longitude;
    @CsvBindByName(column = "English Facility NAICS Code Description / Description du code SCIAN de l'installation en anglais")
    private String facilityDescriptionEnglish;
    @CsvBindByName(column = "French Facility NAICS Code Description / Description du code SCIAN de l'installation en français")
    private String facilityDescriptionFrench;
    @CsvBindByName(column = "Reporting Company Legal Name / Dénomination sociale de la société déclarante")
    private String reportingCompanyLegalName;
    @CsvBindByName(column = "Reporting Company Trade Name / Nom commercial de la société déclarante")
    private String reportingCompanyTradeName;
    @CsvBindByName(column = "Reporting Company Business Number / Numéro d'entreprise de la société déclarante")
    private int reportingCompanyBusinessNumber;
    @CsvBindByName(column = "Public Contact Name / Nom du responsable des renseignements au public")
    private String publicContactName;
    @CsvBindByName(column = "Public Contact Position / Poste ou Titre du responsable des renseignements au public")
    private String publicContactPosition;
    @CsvBindByName(column = "Public Contact Telephone / Numéro de téléphone du responsable des renseignements au public")
    private String publicContactTelephone;
    @CsvBindByName(column = "Public Contact Extension / Poste téléphonique du responsable des renseignements au public")
    private String publicContactExtension;
    @CsvBindByName(column = "Public Contact Email / Adresse électronique du responsable des renseignements au public")
    private String publicContactEmail;
    @CsvBindByName(column = "Public Contact Mailing Address / Adresse postale du responsable des renseignements au public")
    private String publicContactMailingAddress;
    @CsvBindByName(column = "Public Contact City or District or Municipality / Ville ou District ou Municipalité du responsable des renseignements au public")
    private String publicContactCityOrDistrict;
    @CsvBindByName(column = "Public Contact Postal Code / Code postal du responsable des renseignement au public")
    private String publicContactPostalCode;
    @CsvBindByName(column = "CO2 (tonnes)")
    private double co2Tonnes;
    @CsvBindByName(column = "CH4 (tonnes)")
    private double ch4Tonnes;
    @CsvBindByName(column = "CH4 (tonnes CO2e / tonnes éq. CO2)")
    private double ch4Co2TonnesEquivalent;
    @CsvBindByName(column = "N2O (tonnes)")
    private double n2oTonnes;
    @CsvBindByName(column = "N2O (tonnes CO2e / tonnes éq. CO2)")
    private double n2oCo2TonnesEquivalent;
    @CsvBindByName(column = "HFC-23 (tonnes)")
    private double hfc23Tonnes;
    @CsvBindByName(column = "HFC-23 (tonnes CO2e / tonnes éq. CO2)")
    private double hfc23Co2TonnesEquivalent;
    @CsvBindByName(column = "HFC-32 (tonnes)")
    private double hfc32Tonnes;
    @CsvBindByName(column = "HFC-32 (tonnes CO2e / tonnes éq. CO2)")
    private double hfc32Co2TonnesEquivalent;
    @CsvBindByName(column = "HFC-41 (tonnes)")
    private double hfc41Tonnes;
    @CsvBindByName(column = "HFC-41 (tonnes CO2e / tonnes éq. CO2)")
    private double hfc41Co2TonnesEquivalent;
    @CsvBindByName(column = "HFC-43-10mee (tonnes)")
    private double hfc4310meeTonnes;
    @CsvBindByName(column = "HFC-43-10mee (tonnes CO2e / tonnes éq. CO2)")
    private double hfc4310meeCo2TonnesEquivalent;
    @CsvBindByName(column = "HFC-125 (tonnes)")
    private double hfc125Tonnes;
    @CsvBindByName(column = "HFC-125 (tonnes CO2e / tonnes éq. CO2)")
    private double hfc125Co2TonnesEquivalent;
    @CsvBindByName(column = "HFC-134 (tonnes)")
    private double hfc134Tonnes;
    @CsvBindByName(column = "HFC-134 (tonnes CO2e / tonnes éq. CO2)")
    private double hfc134Co2TonnesEquivalent;
    @CsvBindByName(column = "HFC-134a (tonnes)")
    private double hfc134aTonnes;
    @CsvBindByName(column = "HFC-134a (tonnes CO2e / tonnes éq. CO2)")
    private double hfc134aCo2TonnesEquivalent;
    @CsvBindByName(column = "HFC-143 (tonnes)")
    private double hfc143Tonnes;
    @CsvBindByName(column = "HFC-143 (tonnes CO2e / tonnes éq. CO2)")
    private double hfc143Co2TonnesEquivalent;
    @CsvBindByName(column = "HFC-143a (tonnes)")
    private double hfc143aTonnes;
    @CsvBindByName(column = "HFC-143a (tonnes CO2e / tonnes éq. CO2)")
    private double hfc143aCo2TonnesEquivalent;
    @CsvBindByName(column = "HFC-152a (tonnes)")
    private double hfc152aTonnes;
    @CsvBindByName(column = "HFC-152a (tonnes CO2e / tonnes éq. CO2)")
    private double hfc152aCo2TonnesEquivalent;
    @CsvBindByName(column = "HFC-227ea (tonnes)")
    private double hfc227eaTonnes;
    @CsvBindByName(column = "HFC-227ea (tonnes CO2e / tonnes éq. CO2)")
    private double hfc227eaCo2TonnesEquivalent;
    @CsvBindByName(column = "HFC-236fa (tonnes)")
    private double hfc236faTonnes;
    @CsvBindByName(column = "HFC-236fa (tonnes CO2e / tonnes éq. CO2)")
    private double hfc236faCo2TonnesEquivalent;
    @CsvBindByName(column = "HFC-245ca (tonnes)")
    private double hfc245caTonnes;
    @CsvBindByName(column = "HFC-245ca (tonnes CO2e / tonnes éq. CO2)")
    private double hfc245caCo2TonnesEquivalent;
    @CsvBindByName(column = "CF4 (tonnes)")
    private double cf4Tonnes;
    @CsvBindByName(column = "CF4 (tonnes CO2e / tonnes éq. CO2)")
    private double cf4Co2TonnesEquivalent;
    @CsvBindByName(column = "C2F6 (tonnes)")
    private double c2f6Tonnes;
    @CsvBindByName(column = "C2F6 (tonnes CO2e / tonnes éq. CO2)")
    private double c2f6Co2TonnesEquivalent;
    @CsvBindByName(column = "C3F8 (tonnes)")
    private double c3f8Tonnes;
    @CsvBindByName(column = "C3F8 (tonnes CO2e / tonnes éq. CO2)")
    private double c3f8Co2TonnesEquivalent;
    @CsvBindByName(column = "C4F10 (tonnes)")
    private double c4f10Tonnes;
    @CsvBindByName(column = "C4F10 (tonnes CO2e / tonnes éq. CO2)")
    private double c4f10Co2TonnesEquivalent;
    @CsvBindByName(column = "C4F8 (tonnes)")
    private double c4f8Tonnes;
    @CsvBindByName(column = "C4F8 (tonnes CO2e / tonnes éq. CO2)")
    private double c4f8Co2TonnesEquivalent;
    @CsvBindByName(column = "C5F12 (tonnes)")
    private double c5F12Tonnes;
    @CsvBindByName(column = "C5F12 (tonnes CO2e / tonnes éq. CO2)")
    private double c5F12Co2TonnesEquivalent;
    @CsvBindByName(column = "C6F14 (tonnes)")
    private double c6F14Tonnes;
    @CsvBindByName(column = "C6F14 (tonnes CO2e / tonnes éq. CO2)")
    private double c6F14Co2TonnesEquivalent;
    @CsvBindByName(column = "PFC Total (tonnes CO2e / tonnes éq. CO2)")
    private double pfcTotalCo2Tonnes;
    @CsvBindByName(column = "SF6 (tonnes)")
    private double sf6Tonnes;
    @CsvBindByName(column = "SF6 (tonnes CO2e / tonnes éq. CO2)")
    private double sf6Co2TonnesEquivalent;
    @CsvBindByName(column = "Total Emissions (tonnes CO2e) / Émissions totales (tonnes éq. CO2)")
    private double totalEmissionsTonnes;
}
