package com.emissions.industrialemissionsmap.service.region;

import com.emissions.industrialemissionsmap.dto.AtlanticDto;
import com.emissions.industrialemissionsmap.dto.EmitterDto;
import com.emissions.industrialemissionsmap.dto.MaritimeDto;
import com.emissions.industrialemissionsmap.mapper.AggregateEmitterMapper;
import com.emissions.industrialemissionsmap.mapper.EmitterMapper;
import com.emissions.industrialemissionsmap.mapper.RegionMapper;
import com.emissions.industrialemissionsmap.model.DataSet;
import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.repository.EmitterRepository;
import com.emissions.industrialemissionsmap.service.DataSetService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtlanticServiceImpl implements AtlanticService {
    private final EmitterRepository emitterRepository;
    private final EmitterMapper emitterMapper;
    private final RegionMapper regionMapper;
    private final DataSetService dataSetService;

    public AtlanticServiceImpl(EmitterRepository emitterRepository, EmitterMapper emitterMapper, RegionMapper regionMapper, DataSetService dataSetService) {
        this.emitterRepository = emitterRepository;
        this.emitterMapper = emitterMapper;
        this.regionMapper = regionMapper;
        this.dataSetService = dataSetService;
    }

    private AtlanticDto getSingleEmitter(int year) {
        DataSet activeDataSet = dataSetService.findActiveDataSet();
        List<Emitter> novaScotiaEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritoryAndDataSet(year, "Nova Scotia", activeDataSet);
        List<Emitter> peiEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritoryAndDataSet(year, "Prince Edward Island", activeDataSet);
        List<Emitter> newBrunswickEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritoryAndDataSet(year, "New Brunswick", activeDataSet);
        List<Emitter> newfoundlandEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritoryAndDataSet(year, "Newfoundland and Labrador", activeDataSet);
        return mapToDto(novaScotiaEmitters, peiEmitters, newBrunswickEmitters, newfoundlandEmitters);
    }

    @Override
    public AtlanticDto getEmitters(List<Integer> years) {
        if(years.size() == 1) {
            return getSingleEmitter(years.getFirst());
        } else if(years.size() > 1) {
            return getSummedEmitters(years);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Years list was empty.");
        }
    }

    private AtlanticDto getSummedEmitters(List<Integer> years) {
        DataSet activeDataSet = dataSetService.findActiveDataSet();
        List<List<Object[]>> pronviceData = new ArrayList<>();
        pronviceData.add(emitterRepository.sumYearsByFacilityProvinceTerritory(years,  "Nova Scotia", activeDataSet));
        pronviceData.add(emitterRepository.sumYearsByFacilityProvinceTerritory(years,  "Prince Edward Island", activeDataSet));
        pronviceData.add(emitterRepository.sumYearsByFacilityProvinceTerritory(years,  "New Brunswick", activeDataSet));
        pronviceData.add(emitterRepository.sumYearsByFacilityProvinceTerritory(years,  "NewFoundLand", activeDataSet));
        List<List<Emitter>> emitters = AggregateEmitterMapper.mapAggregateEmittersListToEmitters(pronviceData);
        return mapToDto(emitters.get(0), emitters.get(1), emitters.get(2), emitters.get(3));
    }

    @Override
    public AtlanticDto getEmittersAllYearsSum() {
        DataSet activeDataSet = dataSetService.findActiveDataSet();
        List<Integer> years = activeDataSet.getYears().stream().toList();
        return getSummedEmitters(years);
    }

    private AtlanticDto mapToDto(List<Emitter> novaScotiaEmitters,
                                         List<Emitter> peiEmitters,
                                         List<Emitter> newBrunswickEmitters,
                                         List<Emitter> newfoundlandEmitters ) {
        List<EmitterDto> novaScotiaEmitterDto = emitterMapper.emittersToEmitterDtos(novaScotiaEmitters);
        List<EmitterDto> peiEmitterDto = emitterMapper.emittersToEmitterDtos(peiEmitters);
        List<EmitterDto> newBrunswickEmitterDto = emitterMapper.emittersToEmitterDtos(newBrunswickEmitters);
        List<EmitterDto> newfoundlandEmitterDto = emitterMapper.emittersToEmitterDtos(newfoundlandEmitters);
        return regionMapper.provincesToAtlantic(novaScotiaEmitterDto, peiEmitterDto, newBrunswickEmitterDto, newfoundlandEmitterDto);
    }
}
