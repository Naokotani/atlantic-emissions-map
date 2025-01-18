package com.emissions.industrialemissionsmap.dto;

import lombok.Data;

@Data
public class DetailsDto {
    private Integer id;
    private String facilityName;
    private String facilityLocation;
    private String facilityCityOrDistrict;
    private String facilityProvinceTerritory;
    private String facilityPostalCode;
    private double latitude;
    private double longitude;
    private String facilityDescription;
    private String companyLegalName;
    private String companyTradeName;
    private int businessNumber;
    private String publicContactName;
    private String publicContactPosition;
    private String publicContactTelephone;
    private String publicContactExtension;
    private String publicContactEmail;
    private String publicContactMailingAddress;
    private String publicContactCityOrDistrict;
    private String publicContactPostalCode;
}
