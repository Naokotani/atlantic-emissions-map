package com.emissions.industrialemissionsmap.dto;

import lombok.Data;
import java.util.List;

@Data
public class RegionDto {
    String name;
    List<ProvinceDto> provinceDtoList;
}
