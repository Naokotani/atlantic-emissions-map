package com.emissions.industrialemissionsmap.service.region;

import com.emissions.industrialemissionsmap.dto.AtlanticDto;
import com.emissions.industrialemissionsmap.dto.EmitterDto;
import com.emissions.industrialemissionsmap.mapper.EmitterMapper;
import com.emissions.industrialemissionsmap.mapper.RegionMapper;
import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.repository.EmitterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtlanticServiceImpl implements AtlanticService {

    private final EmitterRepository emitterRepository;
    private final EmitterMapper emitterMapper;
    private final RegionMapper regionMapper;

    public AtlanticServiceImpl(EmitterRepository emitterRepository, EmitterMapper emitterMapper, RegionMapper regionMapper) {
        this.emitterRepository = emitterRepository;
        this.emitterMapper = emitterMapper;
        this.regionMapper = regionMapper;
    }

    @Override
    public AtlanticDto getEmitters(int year) {
        List<Emitter> novaScotiaEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritory(year, "Nova Scotia");
        List<Emitter> peiEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritory(year, "Prince Edward Island");
        List<Emitter> newBrunswickEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritory(year, "New Brunswick");
        List<Emitter> newfoundlandEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritory(year, "Newfoundland and Labrador");
        List<EmitterDto> novaScotiaEmitterDto = emitterMapper.emittersToEmitterDtos(novaScotiaEmitters);
        List<EmitterDto> newBrunswickEmitterDto = emitterMapper.emittersToEmitterDtos(newBrunswickEmitters);
        List<EmitterDto> peiEmitterDto = emitterMapper.emittersToEmitterDtos(peiEmitters);
        List<EmitterDto> newfoundlandEmitterDto = emitterMapper.emittersToEmitterDtos(newfoundlandEmitters);
        return regionMapper.provincesToAtlantic(novaScotiaEmitterDto, peiEmitterDto, newBrunswickEmitterDto, newfoundlandEmitterDto);
    }
}
