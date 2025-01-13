package com.emissions.industrialemissionsmap.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmitterCsvRepresentation {
    //TODO not parsing correctly
    @CsvBindByPosition(position = 0)
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
    private String facilityProvinceOrTerritory;
    @CsvBindByName(column = "Facility Postal Code / Code postal de l'installation")
    private String facilityPostalCode;
    @CsvBindByName(column = "Latitude")
    private String latitude;
    @CsvBindByName(column = "Longitude")
    private String longitude;
    @CsvBindByName(column = "English Facility NAICS Code Description / Description du code SCIAN de l'installation en anglais")
    private String facilityDescriptionEnglish;
    @CsvBindByName(column = "French Facility NAICS Code Description / Description du code SCIAN de l'installation en français")
    private String facilityDescriptionFrench;
    @CsvBindByName(column = "Reporting Company Legal Name / Dénomination sociale de la société déclarante")
    private String reportingCompanyLegalName;
    @CsvBindByName(column = "Reporting Company Trade Name / Nom commercial de la société déclarante")
    private String reportingCompanyTradeName;
    @CsvBindByName(column = "Reporting Company Business Number / Numéro d'entreprise de la société déclarante")
    private String reportingCompanyBusinessNumber;
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
    private String co2Tonnes;
    @CsvBindByName(column = "CH4 (tonnes)")
    private String ch4Tonnes;
    @CsvBindByName(column = "CH4 (tonnes CO2e / tonnes éq. CO2)")
    private String ch4Co2TonnesEquivalent;
    @CsvBindByName(column = "N2O (tonnes)")
    private String n2oTonnes;
    @CsvBindByName(column = "N2O (tonnes CO2e / tonnes éq. CO2)")
    private String n2oCo2TonnesEquivalent;
    @CsvBindByName(column = "HFC-23 (tonnes)")
    private String hfc23Tonnes;
    @CsvBindByName(column = "HFC-23 (tonnes CO2e / tonnes éq. CO2)")
    private String hfc23Co2TonnesEquivalent;
    @CsvBindByName(column = "HFC-32 (tonnes)")
    private String hfc32Tonnes;
    @CsvBindByName(column = "HFC-32 (tonnes CO2e / tonnes éq. CO2)")
    private String hfc32Co2TonnesEquivalent;
    @CsvBindByName(column = "HFC-41 (tonnes)")
    private String hfc41Tonnes;
    @CsvBindByName(column = "HFC-41 (tonnes CO2e / tonnes éq. CO2)")
    private String hfc41Co2TonnesEquivalent;
    @CsvBindByName(column = "HFC-43-10mee (tonnes)")
    private String hfc4310meeTonnes;
    @CsvBindByName(column = "HFC-43-10mee (tonnes CO2e / tonnes éq. CO2)")
    private String hfc4310meeCo2TonnesEquivalent;
    @CsvBindByName(column = "HFC-125 (tonnes)")
    private String hfc125Tonnes;
    @CsvBindByName(column = "HFC-125 (tonnes CO2e / tonnes éq. CO2)")
    private String hfc125Co2TonnesEquivalent;
    @CsvBindByName(column = "HFC-134 (tonnes)")
    private String hfc134Tonnes;
    @CsvBindByName(column = "HFC-134 (tonnes CO2e / tonnes éq. CO2)")
    private String hfc134Co2TonnesEquivalent;
    @CsvBindByName(column = "HFC-134a (tonnes)")
    private String hfc134aTonnes;
    @CsvBindByName(column = "HFC-134a (tonnes CO2e / tonnes éq. CO2)")
    private String hfc134aCo2TonnesEquivalent;
    @CsvBindByName(column = "HFC-143 (tonnes)")
    private String hfc143Tonnes;
    @CsvBindByName(column = "HFC-143 (tonnes CO2e / tonnes éq. CO2)")
    private String hfc143Co2TonnesEquivalent;
    @CsvBindByName(column = "HFC-143a (tonnes)")
    private String hfc143aTonnes;
    @CsvBindByName(column = "HFC-143a (tonnes CO2e / tonnes éq. CO2)")
    private String hfc143aCo2TonnesEquivalent;
    @CsvBindByName(column = "HFC-152a (tonnes)")
    private String hfc152aTonnes;
    @CsvBindByName(column = "HFC-152a (tonnes CO2e / tonnes éq. CO2)")
    private String hfc152aCo2TonnesEquivalent;
    @CsvBindByName(column = "HFC-227ea (tonnes)")
    private String hfc227eaTonnes;
    @CsvBindByName(column = "HFC-227ea (tonnes CO2e / tonnes éq. CO2)")
    private String hfc227eaCo2TonnesEquivalent;
    @CsvBindByName(column = "HFC-236fa (tonnes)")
    private String hfc236faTonnes;
    @CsvBindByName(column = "HFC-236fa (tonnes CO2e / tonnes éq. CO2)")
    private String hfc236faCo2TonnesEquivalent;
    @CsvBindByName(column = "HFC-245ca (tonnes)")
    private String hfc245caTonnes;
    @CsvBindByName(column = "HFC-245ca (tonnes CO2e / tonnes éq. CO2)")
    private String hfc245caCo2TonnesEquivalent;
    @CsvBindByName(column = "CF4 (tonnes)")
    private String cf4Tonnes;
    @CsvBindByName(column = "CF4 (tonnes CO2e / tonnes éq. CO2)")
    private String cf4Co2TonnesEquivalent;
    @CsvBindByName(column = "C2F6 (tonnes)")
    private String c2f6Tonnes;
    @CsvBindByName(column = "C2F6 (tonnes CO2e / tonnes éq. CO2)")
    private String c2f6Co2TonnesEquivalent;
    @CsvBindByName(column = "C3F8 (tonnes)")
    private String c3f8Tonnes;
    @CsvBindByName(column = "C3F8 (tonnes CO2e / tonnes éq. CO2)")
    private String c3f8Co2TonnesEquivalent;
    @CsvBindByName(column = "C4F10 (tonnes)")
    private String c4f10Tonnes;
    @CsvBindByName(column = "C4F10 (tonnes CO2e / tonnes éq. CO2)")
    private String c4f10Co2TonnesEquivalent;
    @CsvBindByName(column = "C4F8 (tonnes)")
    private String c4f8Tonnes;
    @CsvBindByName(column = "C4F8 (tonnes CO2e / tonnes éq. CO2)")
    private String c4f8Co2TonnesEquivalent;
    @CsvBindByName(column = "C5F12 (tonnes)")
    private String c5F12Tonnes;
    @CsvBindByName(column = "C5F12 (tonnes CO2e / tonnes éq. CO2)")
    private String c5F12Co2TonnesEquivalent;
    @CsvBindByName(column = "C6F14 (tonnes)")
    private String c6F14Tonnes;
    @CsvBindByName(column = "C6F14 (tonnes CO2e / tonnes éq. CO2)")
    private String c6F14Co2TonnesEquivalent;
    @CsvBindByName(column = "PFC Total (tonnes CO2e / tonnes éq. CO2)")
    private String pfcTotalCo2Tonnes;
    @CsvBindByName(column = "SF6 (tonnes)")
    private String sf6Tonnes;
    @CsvBindByName(column = "SF6 (tonnes CO2e / tonnes éq. CO2)")
    private String sf6Co2TonnesEquivalent;
    @CsvBindByName(column = "Total Emissions (tonnes CO2e) / Émissions totales (tonnes éq. CO2)")
    private String totalEmissionsTonnes;

    //TODO lombok @Getter is not working correctly with this class
    public String getGhgrpId() {
        return ghgrpId;
    }

    public int getYear() {
        return year;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public String getFacilityLocation() {
        return facilityLocation;
    }

    public String getFacilityCityOrDistrict() {
        return facilityCityOrDistrict;
    }

    public String getFacilityProvinceOrTerritory() {
        return facilityProvinceOrTerritory;
    }

    public String getFacilityPostalCode() {
        return facilityPostalCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getFacilityDescriptionEnglish() {
        return facilityDescriptionEnglish;
    }

    public String getFacilityDescriptionFrench() {
        return facilityDescriptionFrench;
    }

    public String getReportingCompanyLegalName() {
        return reportingCompanyLegalName;
    }

    public String getReportingCompanyTradeName() {
        return reportingCompanyTradeName;
    }

    public String getReportingCompanyBusinessNumber() {
        return reportingCompanyBusinessNumber;
    }

    public String getPublicContactName() {
        return publicContactName;
    }

    public String getPublicContactPosition() {
        return publicContactPosition;
    }

    public String getPublicContactTelephone() {
        return publicContactTelephone;
    }

    public String getPublicContactExtension() {
        return publicContactExtension;
    }

    public String getPublicContactEmail() {
        return publicContactEmail;
    }

    public String getPublicContactMailingAddress() {
        return publicContactMailingAddress;
    }

    public String getPublicContactCityOrDistrict() {
        return publicContactCityOrDistrict;
    }

    public String getPublicContactPostalCode() {
        return publicContactPostalCode;
    }

    public String getCo2Tonnes() {
        return co2Tonnes;
    }

    public String getCh4Tonnes() {
        return ch4Tonnes;
    }

    public String getCh4Co2TonnesEquivalent() {
        return ch4Co2TonnesEquivalent;
    }

    public String getN2oTonnes() {
        return n2oTonnes;
    }

    public String getN2oCo2TonnesEquivalent() {
        return n2oCo2TonnesEquivalent;
    }

    public String getHfc23Tonnes() {
        return hfc23Tonnes;
    }

    public String getHfc23Co2TonnesEquivalent() {
        return hfc23Co2TonnesEquivalent;
    }

    public String getHfc32Tonnes() {
        return hfc32Tonnes;
    }

    public String getHfc32Co2TonnesEquivalent() {
        return hfc32Co2TonnesEquivalent;
    }

    public String getHfc41Tonnes() {
        return hfc41Tonnes;
    }

    public String getHfc41Co2TonnesEquivalent() {
        return hfc41Co2TonnesEquivalent;
    }

    public String getHfc4310meeTonnes() {
        return hfc4310meeTonnes;
    }

    public String getHfc4310meeCo2TonnesEquivalent() {
        return hfc4310meeCo2TonnesEquivalent;
    }

    public String getHfc125Tonnes() {
        return hfc125Tonnes;
    }

    public String getHfc125Co2TonnesEquivalent() {
        return hfc125Co2TonnesEquivalent;
    }

    public String getHfc134Tonnes() {
        return hfc134Tonnes;
    }

    public String getHfc134Co2TonnesEquivalent() {
        return hfc134Co2TonnesEquivalent;
    }

    public String getHfc134aTonnes() {
        return hfc134aTonnes;
    }

    public String getHfc134aCo2TonnesEquivalent() {
        return hfc134aCo2TonnesEquivalent;
    }

    public String getHfc143Tonnes() {
        return hfc143Tonnes;
    }

    public String getHfc143Co2TonnesEquivalent() {
        return hfc143Co2TonnesEquivalent;
    }

    public String getHfc143aTonnes() {
        return hfc143aTonnes;
    }

    public String getHfc143aCo2TonnesEquivalent() {
        return hfc143aCo2TonnesEquivalent;
    }

    public String getHfc152aTonnes() {
        return hfc152aTonnes;
    }

    public String getHfc152aCo2TonnesEquivalent() {
        return hfc152aCo2TonnesEquivalent;
    }

    public String getHfc227eaTonnes() {
        return hfc227eaTonnes;
    }

    public String getHfc227eaCo2TonnesEquivalent() {
        return hfc227eaCo2TonnesEquivalent;
    }

    public String getHfc236faTonnes() {
        return hfc236faTonnes;
    }

    public String getHfc236faCo2TonnesEquivalent() {
        return hfc236faCo2TonnesEquivalent;
    }

    public String getHfc245caTonnes() {
        return hfc245caTonnes;
    }

    public String getHfc245caCo2TonnesEquivalent() {
        return hfc245caCo2TonnesEquivalent;
    }

    public String getCf4Tonnes() {
        return cf4Tonnes;
    }

    public String getCf4Co2TonnesEquivalent() {
        return cf4Co2TonnesEquivalent;
    }

    public String getC2f6Tonnes() {
        return c2f6Tonnes;
    }

    public String getC2f6Co2TonnesEquivalent() {
        return c2f6Co2TonnesEquivalent;
    }

    public String getC3f8Tonnes() {
        return c3f8Tonnes;
    }

    public String getC3f8Co2TonnesEquivalent() {
        return c3f8Co2TonnesEquivalent;
    }

    public String getC4f10Tonnes() {
        return c4f10Tonnes;
    }

    public String getC4f10Co2TonnesEquivalent() {
        return c4f10Co2TonnesEquivalent;
    }

    public String getC4f8Tonnes() {
        return c4f8Tonnes;
    }

    public String getC4f8Co2TonnesEquivalent() {
        return c4f8Co2TonnesEquivalent;
    }

    public String getC5F12Tonnes() {
        return c5F12Tonnes;
    }

    public String getC5F12Co2TonnesEquivalent() {
        return c5F12Co2TonnesEquivalent;
    }

    public String getC6F14Tonnes() {
        return c6F14Tonnes;
    }

    public String getC6F14Co2TonnesEquivalent() {
        return c6F14Co2TonnesEquivalent;
    }

    public String getPfcTotalCo2Tonnes() {
        return pfcTotalCo2Tonnes;
    }

    public String getSf6Tonnes() {
        return sf6Tonnes;
    }

    public String getSf6Co2TonnesEquivalent() {
        return sf6Co2TonnesEquivalent;
    }

    public String getTotalEmissionsTonnes() {
        return totalEmissionsTonnes;
    }
}
