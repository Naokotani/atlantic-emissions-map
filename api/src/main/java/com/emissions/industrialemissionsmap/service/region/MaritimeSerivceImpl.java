package com.emissions.industrialemissionsmap.service.region;

import com.emissions.industrialemissionsmap.dto.EmitterDto;
import com.emissions.industrialemissionsmap.dto.MaritimeDto;
import com.emissions.industrialemissionsmap.mapper.EmitterMapper;
import com.emissions.industrialemissionsmap.mapper.RegionMapper;
import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.repository.EmitterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaritimeSerivceImpl implements MaritimeService {

    private final EmitterRepository emitterRepository;
    private final EmitterMapper emitterMapper;
    private final RegionMapper regionMapper;

    public MaritimeSerivceImpl(EmitterRepository emitterRepository, EmitterMapper emitterMapper, RegionMapper regionMapper) {
        this.emitterRepository = emitterRepository;
        this.emitterMapper = emitterMapper;
        this.regionMapper = regionMapper;
    }

    @Override
    public MaritimeDto getEmitters(int year) {
        List<Emitter> novaScotiaEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritory(year, "Nova Scotia");
        List<Emitter> peiEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritory(year, "Prince Edward Island");
        List<Emitter> newBrunswickEmitters = emitterRepository
                .findAllByYearAndFacilityProvinceTerritory(year, "New Brunswick");
        List<EmitterDto> novaScotiaEmitterDto = emitterMapper.emittersToEmitterDtos(novaScotiaEmitters);
        List<EmitterDto> newBruswickEmitterDto = emitterMapper.emittersToEmitterDtos(newBrunswickEmitters);
        List<EmitterDto> peiEmitterDto = emitterMapper.emittersToEmitterDtos(peiEmitters);
        return regionMapper.provincesToMaritime(novaScotiaEmitterDto, newBruswickEmitterDto, peiEmitterDto);
    }
}
