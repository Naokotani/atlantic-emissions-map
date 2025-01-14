package com.emissions.industrialemissionsmap.dto;

import lombok.Data;
import java.util.List;

@Data
public class ProvinceDto {
    private String name;
    private List<EmitterDto> emitters;
}
