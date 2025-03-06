package com.emissions.industrialemissionsmap.service;

import com.emissions.industrialemissionsmap.dto.DataSetDto;
import com.emissions.industrialemissionsmap.model.DataSet;

import java.util.Optional;

public interface DataSetService {
    DataSet findMostRecent();
    DataSet findActiveDataSet();
    DataSetDto setActiveDataSet(long id);
}
