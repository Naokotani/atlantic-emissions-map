package com.emissions.industrialemissionsmap.service;

import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.model.EmitterCsvRepresentation;
import com.emissions.industrialemissionsmap.repository.EmitterRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UploadServiceImpl implements UploadService {

    private final EmitterRepository repository;

    public UploadServiceImpl(EmitterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Integer uploadGhgData(MultipartFile file) throws IOException {
        Set<Emitter> emitters = parseCsv(file);
        repository.saveAll(emitters);
        return emitters.size();
    }

    private Set<Emitter> parseCsv(MultipartFile file) throws IOException {
        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<EmitterCsvRepresentation> strategy =
                    new HeaderColumnNameMappingStrategy<>();
            strategy.setType(EmitterCsvRepresentation.class);
            CsvToBean<EmitterCsvRepresentation> csvToBean =
                    new CsvToBeanBuilder<EmitterCsvRepresentation>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();
            return csvToBean.parse()
                    .stream()
                    .map(csvLine -> new Emitter(
                            csvLine.getGhgrpId(),
                            csvLine.getYear(),
                            csvLine.getFacilityName(),
                            csvLine.getFacilityLocation(),
                            csvLine.getFacilityCityOrDistrict(),
                            csvLine.getFacilityProvinceOrTerritory(),
                            csvLine.getFacilityPostalCode(),
                            csvLine.getLatitude(),
                            csvLine.getLongitude(),
                            csvLine.getFacilityDescriptionEnglish(),
                            csvLine.getFacilityDescriptionFrench(),
                            csvLine.getReportingCompanyLegalName(),
                            csvLine.getReportingCompanyTradeName(),
                            csvLine.getReportingCompanyBusinessNumber(),
                            csvLine.getPublicContactName(),
                            csvLine.getPublicContactPosition(),
                            csvLine.getPublicContactTelephone(),
                            csvLine.getPublicContactExtension(),
                            csvLine.getPublicContactEmail(),
                            csvLine.getPublicContactMailingAddress(),
                            csvLine.getPublicContactCityOrDistrict(),
                            csvLine.getPublicContactPostalCode(),
                            csvLine.getCo2Tonnes(),
                            csvLine.getCh4Tonnes(),
                            csvLine.getCh4Co2TonnesEquivalent(),
                            csvLine.getN2oTonnes(),
                            csvLine.getN2oCo2TonnesEquivalent(),
                            csvLine.getHfc23Tonnes(),
                            csvLine.getHfc23Co2TonnesEquivalent(),
                            csvLine.getHfc32Tonnes(),
                            csvLine.getHfc32Co2TonnesEquivalent(),
                            csvLine.getHfc41Tonnes(),
                            csvLine.getHfc41Co2TonnesEquivalent(),
                            csvLine.getHfc4310meeTonnes(),
                            csvLine.getHfc4310meeCo2TonnesEquivalent(),
                            csvLine.getHfc125Tonnes(),
                            csvLine.getHfc125Co2TonnesEquivalent(),
                            csvLine.getHfc134Tonnes(),
                            csvLine.getHfc134Co2TonnesEquivalent(),
                            csvLine.getHfc134aTonnes(),
                            csvLine.getHfc134aCo2TonnesEquivalent(),
                            csvLine.getHfc143Tonnes(),
                            csvLine.getHfc143Co2TonnesEquivalent(),
                            csvLine.getHfc143aTonnes(),
                            csvLine.getHfc143aCo2TonnesEquivalent(),
                            csvLine.getHfc152aTonnes(),
                            csvLine.getHfc152aCo2TonnesEquivalent(),
                            csvLine.getHfc227eaTonnes(),
                            csvLine.getHfc227eaCo2TonnesEquivalent(),
                            csvLine.getHfc236faTonnes(),
                            csvLine.getHfc236faCo2TonnesEquivalent(),
                            csvLine.getHfc245caTonnes(),
                            csvLine.getHfc245caCo2TonnesEquivalent(),
                            csvLine.getCf4Tonnes(),
                            csvLine.getCf4Co2TonnesEquivalent(),
                            csvLine.getC2f6Tonnes(),
                            csvLine.getC2f6Co2TonnesEquivalent(),
                            csvLine.getC3f8Tonnes(),
                            csvLine.getC3f8Co2TonnesEquivalent(),
                            csvLine.getC4f10Tonnes(),
                            csvLine.getC4f10Co2TonnesEquivalent(),
                            csvLine.getC4f8Tonnes(),
                            csvLine.getC4f8Co2TonnesEquivalent(),
                            csvLine.getC5F12Tonnes(),
                            csvLine.getC5F12Co2TonnesEquivalent(),
                            csvLine.getC6F14Tonnes(),
                            csvLine.getC6F14Co2TonnesEquivalent(),
                            csvLine.getPfcTotalCo2Tonnes(),
                            csvLine.getSf6Tonnes(),
                            csvLine.getSf6Co2TonnesEquivalent(),
                            csvLine.getTotalEmissionsTonnes()
                            )
                    )
                    .collect(Collectors.toSet());
        }
    }
}
