package com.emissions.industrialemissionsmap.service;

import com.emissions.industrialemissionsmap.dto.DataSetDto;
import com.emissions.industrialemissionsmap.model.DataSet;

import java.util.List;
import java.util.Optional;

public interface DataSetService {
    DataSet findMostRecent();
    DataSet findActiveDataSet();
    DataSetDto setActiveDataSet(long id);
    List<DataSetDto> findAllDataSets();
    DataSetDto deleteDataSetById(long id);
    void deleteAllDataSets();
}
