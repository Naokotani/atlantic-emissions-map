package com.emissions.industrialemissionsmap.mapper;

import com.emissions.industrialemissionsmap.model.Emitter;

public class AggregateEmitterMapper {
    public static Emitter mapAggregateEmitterToEmitter(Object[] aggregatedEmitter) {
        Emitter emitter = new Emitter();
        emitter.setFacilityName((String)aggregatedEmitter[0]);
        emitter.setFacilityDescriptionEnglish((String)aggregatedEmitter[1]);
        emitter.setReportingCompanyBusinessNumber((Integer) aggregatedEmitter[2]);
        emitter.setFacilityProvinceTerritory((String) aggregatedEmitter[3]);
        emitter.setLatitude((Double) aggregatedEmitter[4]);
        emitter.setLongitude((Double) aggregatedEmitter[5]);
        emitter.setTotalEmissionsTonnes((Double) aggregatedEmitter[6]);
        emitter.setCo2Tonnes((Double) aggregatedEmitter[7]);
        emitter.setCh4Co2TonnesEquivalent((Double) aggregatedEmitter[8]);
        emitter.setN2oCo2TonnesEquivalent((Double) aggregatedEmitter[9]);
        emitter.setSf6Co2TonnesEquivalent((Double) aggregatedEmitter[10]);
        emitter.setPfcTotalCo2Tonnes((Double) aggregatedEmitter[11]);
        emitter.setHfc32Co2TonnesEquivalent((Double) aggregatedEmitter[12]);
        emitter.setHfc41Co2TonnesEquivalent((Double) aggregatedEmitter[13]);
        emitter.setHfc4310meeCo2TonnesEquivalent((Double) aggregatedEmitter[14]);
        emitter.setHfc125Co2TonnesEquivalent((Double) aggregatedEmitter[15]);
        emitter.setHfc134aCo2TonnesEquivalent((Double) aggregatedEmitter[16]);
        emitter.setHfc134aCo2TonnesEquivalent((Double) aggregatedEmitter[17]);
        emitter.setHfc143Co2TonnesEquivalent((Double) aggregatedEmitter[18]);
        emitter.setHfc143aCo2TonnesEquivalent((Double) aggregatedEmitter[19]);
        emitter.setHfc152aCo2TonnesEquivalent((Double) aggregatedEmitter[20]);
        emitter.setHfc227eaCo2TonnesEquivalent((Double) aggregatedEmitter[21]);
        emitter.setHfc236faCo2TonnesEquivalent((Double) aggregatedEmitter[22]);
        emitter.setHfc245caCo2TonnesEquivalent((Double) aggregatedEmitter[23]);
        return emitter;
    }
}
