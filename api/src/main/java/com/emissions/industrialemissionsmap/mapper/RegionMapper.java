package com.emissions.industrialemissionsmap.mapper;

import com.emissions.industrialemissionsmap.dto.AtlanticDto;
import com.emissions.industrialemissionsmap.dto.EmitterDto;
import com.emissions.industrialemissionsmap.dto.MaritimeDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegionMapper {
    MaritimeDto provincesToMaritime(List<EmitterDto> novaScotia, List<EmitterDto> pei, List<EmitterDto> newBrunswick);
    AtlanticDto provincesToAtlantic(List<EmitterDto> novaScotia, List<EmitterDto> pei, List<EmitterDto> newBrunswick, List<EmitterDto> newfoundland);
}
