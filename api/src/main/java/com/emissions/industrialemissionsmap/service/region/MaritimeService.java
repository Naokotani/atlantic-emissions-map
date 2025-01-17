package com.emissions.industrialemissionsmap.service.region;

import com.emissions.industrialemissionsmap.dto.MaritimeDto;

public interface MaritimeService {
    MaritimeDto getEmitters(int year);
}
