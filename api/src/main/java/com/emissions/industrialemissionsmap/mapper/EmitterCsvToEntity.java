package com.emissions.industrialemissionsmap.mapper;

import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.model.EmitterCsvRepresentation;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmitterCsvToEntity {
    Set<Emitter> csvToEntity(List<EmitterCsvRepresentation> csvRepresentation);
}
