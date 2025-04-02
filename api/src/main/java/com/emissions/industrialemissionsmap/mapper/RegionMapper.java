package com.emissions.industrialemissionsmap.mapper;

import com.emissions.industrialemissionsmap.dto.AggregateEmitter;
import com.emissions.industrialemissionsmap.dto.MaritimeDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegionMapper {
    MaritimeDto provincesToMaritime(List<AggregateEmitter> novaScotia, List<AggregateEmitter> pei, List<AggregateEmitter> newBrunswick);
}
