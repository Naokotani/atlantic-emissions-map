package com.emissions.industrialemissionsmap.service.region;

import com.emissions.industrialemissionsmap.dto.EmitterDto;
import com.emissions.industrialemissionsmap.dto.MaritimeDto;
import com.emissions.industrialemissionsmap.mapper.EmitterMapper;
import com.emissions.industrialemissionsmap.mapper.RegionMapper;
import com.emissions.industrialemissionsmap.model.DataSet;
import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.repository.EmitterRepository;
import com.emissions.industrialemissionsmap.service.DataSetService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MaritimeSerivceImpl implements MaritimeService {

    private final EmitterRepository emitterRepository;
    private final EmitterMapper emitterMapper;
    private final RegionMapper regionMapper;
    private final DataSetService dataSetService;

    public MaritimeSerivceImpl(EmitterRepository emitterRepository, EmitterMapper emitterMapper, RegionMapper regionMapper, DataSetService dataSetService) {
        this.emitterRepository = emitterRepository;
        this.emitterMapper = emitterMapper;
        this.regionMapper = regionMapper;
        this.dataSetService = dataSetService;
    }

    private MaritimeDto getSingleEmitter(int year) {
        DataSet activeDataSet = dataSetService.findActiveDataSet();
        List<Emitter> novaScotiaEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritoryAndDataSet(year, "Nova Scotia", activeDataSet);
        List<Emitter> peiEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritoryAndDataSet(year, "Prince Edward Island", activeDataSet);
        List<Emitter> newBrunswickEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritoryAndDataSet(year, "New Brunswick", activeDataSet);
        return mapToAtlanticDto(novaScotiaEmitters, peiEmitters, newBrunswickEmitters);
    }

    @Override
    public MaritimeDto getEmitters(List<Integer> years) {
        if(years.size() == 1) {
            return getSingleEmitter(years.getFirst());
        } else if(years.size() > 2) {
            return getSummedEmitters(years);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Years list was empty.");
        }
    }

    // TODO
    @Override
    public MaritimeDto getEmittersAllYearsSum() {
        return null;
    }

    @Override
    public MaritimeDto getSummedEmitters(List<Integer> years) {
        DataSet activeDataSet = dataSetService.findActiveDataSet();
        List<Object> objects = emitterRepository.sumYearsByFacilityProvinceTerritory(years,  "Nova Scotia", activeDataSet);
        List<Emitter> novaScotiaEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritoryAndDataSet(years.getFirst(), "Nova Scotia", activeDataSet);
        List<Emitter> peiEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritoryAndDataSet(years.getFirst(), "Prince Edward Island", activeDataSet);
        List<Emitter> newBrunswickEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritoryAndDataSet(years.getFirst(), "New Brunswick", activeDataSet);
        return mapToAtlanticDto(novaScotiaEmitters, peiEmitters, newBrunswickEmitters);
    }

    private MaritimeDto mapToAtlanticDto(List<Emitter> novaScotiaEmitters,
                                         List<Emitter> peiEmitters,
                                         List<Emitter> newBrunswickEmitters ) {
        List<EmitterDto> novaScotiaEmitterDto = emitterMapper.emittersToEmitterDtos(novaScotiaEmitters);
        List<EmitterDto> newBrunswickEmitterDto = emitterMapper.emittersToEmitterDtos(newBrunswickEmitters);
        List<EmitterDto> peiEmitterDto = emitterMapper.emittersToEmitterDtos(peiEmitters);
        return regionMapper.provincesToMaritime(novaScotiaEmitterDto, peiEmitterDto, newBrunswickEmitterDto);
    }
}
