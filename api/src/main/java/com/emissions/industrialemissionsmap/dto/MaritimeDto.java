package com.emissions.industrialemissionsmap.dto;

import lombok.Data;
import java.util.List;

@Data
public class MaritimeDto {
    private List<EmitterDto> novaScotia;
    private List<EmitterDto> newBrunswick;
    private List<EmitterDto> pei;
}
