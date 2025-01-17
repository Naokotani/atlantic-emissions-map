package com.emissions.industrialemissionsmap.service;

import com.emissions.industrialemissionsmap.mapper.EmitterCsvToEntity;
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
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

@Service
public class UploadServiceImpl implements UploadService {

    private final EmitterRepository repository;
    private final EmitterCsvToEntity emitterCsvToEntity;

    public UploadServiceImpl(EmitterRepository repository, EmitterCsvToEntity emitterCsvToEntity) {
        this.repository = repository;
        this.emitterCsvToEntity = emitterCsvToEntity;
    }

    @Override
    public Integer uploadGhgData(MultipartFile file) throws IOException {
        Set<Emitter> emitters = parseCsv(file);
        repository.saveAll(emitters);
        return emitters.size();
    }

    private Set<Emitter> parseCsv(MultipartFile file) throws IOException {
        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            HeaderColumnNameMappingStrategy<EmitterCsvRepresentation> strategy =
                    new HeaderColumnNameMappingStrategy<>();
            strategy.setType(EmitterCsvRepresentation.class);
            CsvToBean<EmitterCsvRepresentation> csvToBean =
                    new CsvToBeanBuilder<EmitterCsvRepresentation>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();
            return emitterCsvToEntity.csvToEntity(csvToBean.parse());
        }
    }
}
