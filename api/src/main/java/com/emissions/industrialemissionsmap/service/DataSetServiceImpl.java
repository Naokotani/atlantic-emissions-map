package com.emissions.industrialemissionsmap.service;

import com.emissions.industrialemissionsmap.dto.DataSetDto;
import com.emissions.industrialemissionsmap.mapper.DataSetMapper;
import com.emissions.industrialemissionsmap.model.DataSet;
import com.emissions.industrialemissionsmap.repository.DataSetRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DataSetServiceImpl implements DataSetService {
    private final DataSetRepository dataSetRepository;
    private final DataSetMapper dataSetMapper;

    public DataSetServiceImpl(DataSetRepository dataSetRepository, DataSetMapper dataSetMapper) {
        this.dataSetRepository = dataSetRepository;
        this.dataSetMapper = dataSetMapper;
    }

    @Override
    public DataSet findMostRecent() throws ResponseStatusException {
        List<DataSet> datasets = dataSetRepository.findAll();
        return datasets.stream()
                .max((e1, e2) -> e1.getUploaded().compareTo(e2.getUploaded()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public DataSet findActiveDataSet() throws ResponseStatusException {
        return dataSetRepository.findAll().stream().filter(DataSet::isActive).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No active data set found."));
    }

    @Override
    @CacheEvict(value = "maritime", allEntries = true)
    public DataSetDto setActiveDataSet(long id) throws ResponseStatusException {
        DataSet newActiveDataSet = dataSetRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<DataSet> dataSets = dataSetRepository.findAll();
        dataSets.forEach(d -> d.setActive(false));
        dataSetRepository.saveAll(dataSets);
        newActiveDataSet.setActive(true);
        dataSetRepository.save(newActiveDataSet);
        return dataSetMapper.dataSetToDataSetDto(newActiveDataSet);
    }

    @Override
    public List<DataSetDto> findAllDataSets() {
        List<DataSet> dataSets = dataSetRepository.findAll();
        return dataSetMapper.dataSetToDataSetDtoList(dataSets);
    }

    @Override
    public DataSetDto deleteDataSetById(long id) throws ResponseStatusException {
        DataSet dataSet = dataSetRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        dataSetRepository.deleteById(id);
        return dataSetMapper.dataSetToDataSetDto(dataSet);
    }

    @Override
    public void deleteAllDataSets() {
        dataSetRepository.deleteAll();
    }

}
