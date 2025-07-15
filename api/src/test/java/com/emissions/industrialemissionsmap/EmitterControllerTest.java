package com.emissions.industrialemissionsmap;

import com.emissions.industrialemissionsmap.dto.EmitterDto;
import com.emissions.industrialemissionsmap.mapper.EmitterMapper;
import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.repository.EmitterRepository;
import com.emissions.industrialemissionsmap.service.DataSetService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class EmitterControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    EmitterMapper emitterMapper;
    @Autowired
    EmitterRepository emitterRepository;
    @Autowired
    DataSetService dataSetService;

    List<Emitter> emitters = new ArrayList<>();

    @BeforeEach
    void setup() {
        emitters.addAll(emitterRepository.findAll());
    }

    @Test
    void detailsControllerTest() throws Exception {
        ResultActions result = mockMvc.perform(get("/api/v1/details"));
    }

    @Test
    void emitterIdTest() throws Exception {
        Emitter emitter = emitters.getFirst();
        String testId = emitter.getId().toString();
        ResultActions result = mockMvc.perform(get("/api/v1/emitter/id")
                .param("id", testId));
        testEmitter(result, emitter);
    }

    @Test
    void emitterNameAndYearTest() throws Exception {
        Emitter emitter = emitters.getFirst();
        String name = emitter.getFacilityName();
        String year = String.valueOf(emitter.getYear());
        ResultActions result = mockMvc.perform(get("/api/v1/emitter/name")
                .param("year", year)
                .param("name", name));
        testEmitter(result, emitter);
    }

    @Test
    void emitterNameAllYearsTest() throws Exception {
        Emitter testEmitter = emitters.getFirst();
        String name = testEmitter.getFacilityName();
        List<Emitter> emitters = emitterRepository.findAllByFacilityNameAndDataSet(name,
                        dataSetService.findActiveDataSet()).orElseThrow();
        ResultActions result = mockMvc.perform(get("/api/v1/emitter/facility-name")
                .param("name", name));
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$", hasSize(emitters.size())));

        for(int i = 0; i < emitters.size(); i++) {
            Emitter emitter = emitters.get(i);
            double totalHydroflourocarbons = getTotalHydroflourocarbons(emitters.get(i));
            result.andExpect(jsonPath("$[" + i + "].ghgrpId").value(emitter.getGhgrpId()));
            result.andExpect(jsonPath("$[" + i + "].facilityName").value(emitter.getFacilityName()));
            result.andExpect(jsonPath("$[" + i + "].facilityDescription").value(emitter.getFacilityDescriptionEnglish()));
            result.andExpect(jsonPath("$[" + i + "].businessNumber").value(emitter.getReportingCompanyBusinessNumber()));
            result.andExpect(jsonPath("$[" + i + "].latitude").value(emitter.getLatitude()));
            result.andExpect(jsonPath("$[" + i + "].longitude").value(emitter.getLongitude()));
            result.andExpect(jsonPath("$[" + i + "].carbonDioxide").value(emitter.getCo2Tonnes()));
            result.andExpect(jsonPath("$[" + i + "].methane").value(emitter.getCh4Co2TonnesEquivalent()));
            result.andExpect(jsonPath("$[" + i + "].nitrousOxide").value(emitter.getN2oCo2TonnesEquivalent()));
            result.andExpect(jsonPath("$[" + i + "].hydroflourocarbons").value(totalHydroflourocarbons));
            result.andExpect(jsonPath("$[" + i + "].perfluorocarbons").value(emitter.getPfcTotalCo2Tonnes()));
            result.andExpect(jsonPath("$[" + i + "].totalEmissions").value(emitter.getTotalEmissionsTonnes()));
        }
    }

    private void testEmitter(ResultActions result, Emitter emitter) throws Exception {
        double totalHydroflourocarbons = getTotalHydroflourocarbons(emitter);
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.ghgrpId").value(emitter.getGhgrpId()));
        result.andExpect(jsonPath("$.facilityName").value(emitter.getFacilityName()));
        result.andExpect(jsonPath("$.facilityDescription").value(emitter.getFacilityDescriptionEnglish()));
        result.andExpect(jsonPath("$.businessNumber").value(emitter.getReportingCompanyBusinessNumber()));
        result.andExpect(jsonPath("$.latitude").value(emitter.getLatitude()));
        result.andExpect(jsonPath("$.longitude").value(emitter.getLongitude()));
        result.andExpect(jsonPath("$.carbonDioxide").value(emitter.getCo2Tonnes()));
        result.andExpect(jsonPath("$.methane").value(emitter.getCh4Co2TonnesEquivalent()));
        result.andExpect(jsonPath("$.nitrousOxide").value(emitter.getN2oCo2TonnesEquivalent()));
        result.andExpect(jsonPath("$.hydroflourocarbons").value(totalHydroflourocarbons));
        result.andExpect(jsonPath("$.perfluorocarbons").value(emitter.getPfcTotalCo2Tonnes()));
        result.andExpect(jsonPath("$.totalEmissions").value(emitter.getTotalEmissionsTonnes()));
        log.debug(result.andReturn().getResponse().getContentAsString());
    }

    private static double getTotalHydroflourocarbons(Emitter emitter) {
        double totalHydroflourocarbons = 0.0;
        totalHydroflourocarbons += emitter.getHfc23Co2TonnesEquivalent();
        totalHydroflourocarbons += emitter.getHfc32Co2TonnesEquivalent();
        totalHydroflourocarbons += emitter.getHfc41Co2TonnesEquivalent();
        totalHydroflourocarbons += emitter.getHfc4310meeCo2TonnesEquivalent();
        totalHydroflourocarbons += emitter.getHfc125Co2TonnesEquivalent();
        totalHydroflourocarbons += emitter.getHfc134Co2TonnesEquivalent();
        totalHydroflourocarbons += emitter.getHfc134aCo2TonnesEquivalent();
        totalHydroflourocarbons += emitter.getHfc143Co2TonnesEquivalent();
        totalHydroflourocarbons += emitter.getHfc143aCo2TonnesEquivalent();
        totalHydroflourocarbons += emitter.getHfc152aCo2TonnesEquivalent();
        totalHydroflourocarbons += emitter.getHfc227eaCo2TonnesEquivalent();
        totalHydroflourocarbons += emitter.getHfc236faCo2TonnesEquivalent();
        totalHydroflourocarbons += emitter.getHfc245caCo2TonnesEquivalent();
        return totalHydroflourocarbons;
    }
}
