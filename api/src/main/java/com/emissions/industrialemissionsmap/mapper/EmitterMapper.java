package com.emissions.industrialemissionsmap.mapper;

import com.emissions.industrialemissionsmap.dto.EmitterDto;
import com.emissions.industrialemissionsmap.model.Emitter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmitterMapper {
    @Mapping(target = "facilityDescription", source = "facilityDescriptionEnglish")
    @Mapping(target = "totalEmissions", source = "totalEmissionsTonnes")
    @Mapping(target = "carbonDioxide", source = "co2Tonnes")
    @Mapping(target = "methane", source = "ch4Co2TonnesEquivalent")
    @Mapping(target = "nitrousOxide", source = "n2oCo2TonnesEquivalent")
    @Mapping(target = "sulphurHexaflouride", source = "sf6Co2TonnesEquivalent")
    @Mapping(target = "hydroflourocarbons", qualifiedByName = "getHydroflourocarbons", source = "emitter")
    @Mapping(target = "perfluorocarbons", source = "pfcTotalCo2Tonnes")
    EmitterDto emitterToEmitterDto(Emitter emitter);
    List<EmitterDto> emittersToEmitterDtos(List<Emitter> emitters);

    @Named("getHydroflourocarbons")
    default double getHydroflourocarbons(Emitter source) {
        double sum = 0;
        sum += source.getHfc23Co2TonnesEquivalent();
        sum += source.getHfc32Co2TonnesEquivalent();
        sum += source.getHfc41Co2TonnesEquivalent();
        sum += source.getHfc4310meeCo2TonnesEquivalent();
        sum += source.getHfc125Co2TonnesEquivalent();
        sum += source.getHfc134Co2TonnesEquivalent();
        sum += source.getHfc134aCo2TonnesEquivalent();
        sum += source.getHfc143Co2TonnesEquivalent();
        sum += source.getHfc143aCo2TonnesEquivalent();
        sum += source.getHfc152aCo2TonnesEquivalent();
        sum += source.getHfc227eaCo2TonnesEquivalent();
        sum += source.getHfc236faCo2TonnesEquivalent();
        sum += source.getHfc245caCo2TonnesEquivalent();
        return sum;
    };
}
