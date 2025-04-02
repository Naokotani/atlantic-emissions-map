package com.emissions.industrialemissionsmap.mapper;

import com.emissions.industrialemissionsmap.dto.AggregateEmitter;

public class AggregateEmitterMapper {
    public static AggregateEmitter mapObjectToAggregateEmitter(Object[] aggregatedEmitter) {
        AggregateEmitter emitter = new AggregateEmitter();
        emitter.setGhgrpId((String)aggregatedEmitter[0]);
        emitter.setTotalEmissionsTonnes((Double) aggregatedEmitter[1]);
        emitter.setCarbonDioxide((Double) aggregatedEmitter[2]);
        emitter.setMethane((Double) aggregatedEmitter[3]);
        emitter.setNitrousOxide((Double) aggregatedEmitter[4]);
        emitter.setSulphurHexaFlouride((Double) aggregatedEmitter[5]);
        emitter.setPerflourocarbons((Double) aggregatedEmitter[6]);

        double hydroflourocarbons = 0.0;
        hydroflourocarbons += (Double) aggregatedEmitter[7];
        hydroflourocarbons += (Double) aggregatedEmitter[8];
        hydroflourocarbons += (Double) aggregatedEmitter[9];
        hydroflourocarbons += (Double) aggregatedEmitter[10];
        hydroflourocarbons += (Double) aggregatedEmitter[11];
        hydroflourocarbons += (Double) aggregatedEmitter[12];
        hydroflourocarbons += (Double) aggregatedEmitter[13];
        hydroflourocarbons += (Double) aggregatedEmitter[14];
        hydroflourocarbons += (Double) aggregatedEmitter[15];
        hydroflourocarbons += (Double) aggregatedEmitter[16];
        hydroflourocarbons += (Double) aggregatedEmitter[17];
        hydroflourocarbons += (Double) aggregatedEmitter[18];

        emitter.setHydroflourocarbons(hydroflourocarbons);

        return emitter;
    }
}
