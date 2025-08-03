package com.emissions.industrialemissionsmap.service.region;

import com.emissions.industrialemissionsmap.dto.AggregateEmitter;
import com.emissions.industrialemissionsmap.dto.MaritimeDto;
import com.emissions.industrialemissionsmap.mapper.AggregateEmitterMapper;
import com.emissions.industrialemissionsmap.mapper.EmitterMapper;
import com.emissions.industrialemissionsmap.mapper.RegionMapper;
import com.emissions.industrialemissionsmap.model.DataSet;
import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.repository.EmitterRepository;
import com.emissions.industrialemissionsmap.service.DataSetService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaritimeSerivceImpl implements MaritimeService {

    private final EmitterRepository emitterRepository;
    private final RegionMapper regionMapper;
    private final DataSetService dataSetService;

    public MaritimeSerivceImpl(EmitterRepository emitterRepository, EmitterMapper emitterMapper, RegionMapper regionMapper, DataSetService dataSetService) {
        this.emitterRepository = emitterRepository;
        this.regionMapper = regionMapper;
        this.dataSetService = dataSetService;
    }

    @Override
    @Cacheable(value = "maritime", key="#years")
    public MaritimeDto getEmitters(List<Integer> years) {
        DataSet activeDataSet = dataSetService.findActiveDataSet();
        List<AggregateEmitter> novaScotiaEmitters = emitterRepository.sumYearsByFacilityProvinceTerritory(years, "Nova Scotia", activeDataSet).stream()
                .map(AggregateEmitterMapper::mapObjectToAggregateEmitter).toList();
        List<AggregateEmitter> peiEmitters
                = emitterRepository.sumYearsByFacilityProvinceTerritory(years, "Prince Edward Island", activeDataSet).stream()
                .map(AggregateEmitterMapper::mapObjectToAggregateEmitter).toList();
        List<AggregateEmitter> newBrunswickEmitters = emitterRepository.sumYearsByFacilityProvinceTerritory(years, "New Brunswick", activeDataSet).stream()
                .map(AggregateEmitterMapper::mapObjectToAggregateEmitter).toList();

        setLatLong(activeDataSet, peiEmitters);

        setLatLong(activeDataSet, newBrunswickEmitters);

        setLatLong(activeDataSet, novaScotiaEmitters);

        return mapToDto(novaScotiaEmitters, peiEmitters, newBrunswickEmitters);
    }

    private void setLatLong(DataSet activeDataSet, List<AggregateEmitter> aggregateEmitters) {
        aggregateEmitters.forEach(e -> {
            List<Emitter> emitters = emitterRepository.findEmitterByGhgrpIdAndDataSet(e.getGhgrpId(), activeDataSet).orElseThrow();
            int currYear = emitters.stream().map(Emitter::getYear).max(Integer::compareTo).orElseThrow();
            e.setLatitude(emitters.stream().filter(emitter -> emitter.getYear() == currYear).findFirst().orElseThrow().getLatitude());
            e.setLongitude(emitters.stream().filter(emitter -> emitter.getYear() == currYear).findFirst().orElseThrow().getLongitude());
        });
    }

    private MaritimeDto mapToDto(List<AggregateEmitter> novaScotiaEmitters,
                                         List<AggregateEmitter> peiEmitters,
                                         List<AggregateEmitter> newBrunswickEmitters ) {
        return regionMapper.provincesToMaritime(novaScotiaEmitters, peiEmitters, newBrunswickEmitters);
    }
}
