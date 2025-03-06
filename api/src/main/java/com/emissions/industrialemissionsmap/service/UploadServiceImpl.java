package com.emissions.industrialemissionsmap.service;

import com.emissions.industrialemissionsmap.mapper.EmitterCsvToEntity;
import com.emissions.industrialemissionsmap.model.DataSet;
import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.model.EmitterCsvRepresentation;
import com.emissions.industrialemissionsmap.repository.DataSetRepository;
import com.emissions.industrialemissionsmap.repository.EmitterRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UploadServiceImpl implements UploadService {

    private final DataSetRepository dataSetRepository;
    private final EmitterRepository emitterRepository;
    private final EmitterCsvToEntity emitterCsvToEntity;

    public UploadServiceImpl(DataSetRepository dataSetRepository, EmitterRepository emitterRepository, EmitterCsvToEntity emitterCsvToEntity) {
        this.dataSetRepository = dataSetRepository;
        this.emitterRepository = emitterRepository;
        this.emitterCsvToEntity = emitterCsvToEntity;
    }

    /**
     Uploads a new dataset to the database settings it's time to now. If the datasets table is empty then it is set
     as the active dataset.
     */
    @Override
    public Integer uploadGhgData(MultipartFile file) throws IOException {
        DataSet dataSet = new DataSet();
        List<DataSet> datasets = dataSetRepository.findAll();
        dataSet.setActive(datasets.isEmpty());
        Set<Emitter> emitters = parseCsv(file);
        dataSet.setUploaded(LocalDateTime.now());
        DataSet savedDataset = dataSetRepository.save(dataSet);
        emitters.forEach(e -> e.setDataSet(savedDataset));
        emitterRepository.saveAll(emitters);
        Set<Integer> years  = new HashSet<>();
        emitters.forEach(emitter -> years.add(emitter.getYear()));
        int currentYear = years.stream()
                .max(Integer::compareTo)
                .orElse(0);
        dataSet.setEmitters(emitters);
        dataSet.setRecords(emitters.size());
        dataSet.setCurrentYear(currentYear);
        dataSet.setYears(years);
        dataSetRepository.save(dataSet);
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
