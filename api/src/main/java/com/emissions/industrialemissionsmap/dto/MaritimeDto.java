package com.emissions.industrialemissionsmap.dto;

import lombok.Data;
import java.util.List;

@Data
public class MaritimeDto {
    private List<AggregateEmitter> novaScotia;
    private List<AggregateEmitter> newBrunswick;
    private List<AggregateEmitter> pei;
}
