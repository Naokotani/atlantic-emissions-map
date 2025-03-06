package com.emissions.industrialemissionsmap.mapper;

import com.emissions.industrialemissionsmap.dto.DataSetDto;
import com.emissions.industrialemissionsmap.model.DataSet;
import com.emissions.industrialemissionsmap.model.Emitter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DataSetMapper {

    @Mapping(target = "active", qualifiedByName = "dataSetActive", source = "dataSet")
    DataSetDto dataSetToDataSetDto(DataSet dataSet);
    List<DataSetDto> dataSetToDataSetDtoList(List<DataSet> dataSets);

    @Named("dataSetActive")
    default boolean dataSetActive(DataSet dataSet) {
        return dataSet.isActive();
    }
}
