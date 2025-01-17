package com.emissions.industrialemissionsmap.dto;

import lombok.Data;

import java.util.List;

@Data
public class AtlanticDto {
    private List<EmitterDto> novaScotia;
    private List<EmitterDto> newBrunswick;
    private List<EmitterDto> newfoundland;
    private List<EmitterDto> pei;
}
