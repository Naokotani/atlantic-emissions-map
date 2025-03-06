package com.emissions.industrialemissionsmap.service.region;

import com.emissions.industrialemissionsmap.dto.AtlanticDto;
import com.emissions.industrialemissionsmap.dto.MaritimeDto;

import java.util.List;

public interface AtlanticService {
    AtlanticDto getEmitters(List<Integer> years);
    AtlanticDto getEmittersAllYearsSum();
}
