package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.dto.DataSetDto;
import com.emissions.industrialemissionsmap.mapper.DataSetMapper;
import com.emissions.industrialemissionsmap.model.DataSet;
import com.emissions.industrialemissionsmap.repository.DataSetRepository;
import com.emissions.industrialemissionsmap.service.DataSetService;
import com.emissions.industrialemissionsmap.service.UploadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/data")
public class DataController {
    private final UploadService service;
    private final DataSetRepository dataSetRepository;
    private final DataSetMapper dataSetMapper;
    private final DataSetService dataSetService;

    public DataController(UploadService service, DataSetRepository dataSetRepository, DataSetMapper dataSetMapper, DataSetService dataSetService) {
        this.service = service;
        this.dataSetRepository = dataSetRepository;
        this.dataSetMapper = dataSetMapper;
        this.dataSetService = dataSetService;
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadGhgData(
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        return ResponseEntity.ok(service.uploadGhgData(file));
    }

    @GetMapping
    public ResponseEntity<List<DataSetDto>>  getDatasets() {
        List<DataSet> datasets = dataSetRepository.findAll();
        List<DataSetDto> dataSetDtos = dataSetMapper.dataSetToDataSetDtoList(datasets);
        return ResponseEntity.ok(dataSetDtos);
    }


    @GetMapping("/active")
    public ResponseEntity<DataSetDto>  getactiveDataSet() {
        DataSet dataSet = dataSetService.findActiveDataSet();
        DataSetDto dataSetDto = dataSetMapper.dataSetToDataSetDto(dataSet);
        return ResponseEntity.ok(dataSetDto);
    }

    @GetMapping("/recent")
    public ResponseEntity<DataSetDto>  getCurrentDatasets() {
        DataSet dataSet = dataSetService.findMostRecent();
       DataSetDto dataSetDto = dataSetMapper.dataSetToDataSetDto(dataSet);
        return ResponseEntity.ok(dataSetDto);
    }

    // TODO appropriate status
    @DeleteMapping("/all")
    public ResponseEntity<String> deleteDatasets() {
        dataSetRepository.deleteAll();
       return new ResponseEntity<>("Datasets deleted", HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteDataSetById(@RequestParam long id) {
        dataSetRepository.deleteById(id);
        return new ResponseEntity<>("Dataset " + id + " deleted", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DataSetDto> setActiveDataSet(@RequestParam long id) {
        DataSetDto dataSetDto = dataSetService.setActiveDataSet(id);
        return new ResponseEntity<>(dataSetDto, HttpStatus.OK);
    }
}
