package com.emissions.industrialemissionsmap;

import com.emissions.industrialemissionsmap.model.DataSet;
import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.repository.EmitterRepository;
import com.emissions.industrialemissionsmap.service.DataSetService;
import com.fasterxml.jackson.databind.JsonNode;
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
class RegionControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    EmitterRepository
    emitterRepository;

    List<Emitter> emitters = new ArrayList<>();
    List<DataSet> dataSets = new ArrayList<>();
    DataSet dataSet;
    @Autowired
    private DataSetService dataSetService;

    @BeforeEach
    void setup() {
        this.dataSet = dataSetService.findActiveDataSet();
    }

    @Test
    void maritimeRegionTest() throws Exception {
        ResultActions result = mockMvc.perform(get("/api/v1/region/maritime").param("years", "2020"));
        result.andExpect(status().isOk());

        String responseContent = result.andReturn().getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(responseContent);
        JsonNode peiJson = root.get("pei");
        JsonNode newBrunswickJson = root.get("newBrunswick");
        JsonNode novaScotiaJson = root.get("novaScotia");

        String peiGhgrpId = peiJson.get(0).get("ghgrpId").asText();
        String newBrunswickGhgrpId = newBrunswickJson.get(0).get("ghgrpId").asText();
        String novaScotiaGhgrpId = novaScotiaJson.get(0).get("ghgrpId").asText();

        List<Emitter> novaScotiaEmitterAllYears = emitterRepository.findEmitterByGhgrpIdAndDataSet(novaScotiaGhgrpId, dataSet)
                .orElseThrow();
        List<Emitter> newBrunswickEmitterAllYears = emitterRepository.findEmitterByGhgrpIdAndDataSet(newBrunswickGhgrpId, dataSet)
                .orElseThrow();
        List<Emitter> peiEmitterAllYears = emitterRepository.findEmitterByGhgrpIdAndDataSet(peiGhgrpId, dataSet)
                .orElseThrow();
        Emitter novaScotiaEmitter = novaScotiaEmitterAllYears.stream().filter(e -> e.getYear() == 2020).toList().getFirst();
        Emitter newBrunswickEmitter = newBrunswickEmitterAllYears.stream().filter(e -> e.getYear() == 2020).toList().getFirst();
        Emitter peiEmitter = peiEmitterAllYears.stream().filter(e -> e.getYear() == 2020).toList().getFirst();

        result.andExpect(jsonPath("$.novaScotia.[0].totalEmissionsTonnes").value(novaScotiaEmitter.getTotalEmissionsTonnes()));
        result.andExpect(jsonPath("$.newBrunswick.[0].totalEmissionsTonnes").value(newBrunswickEmitter.getTotalEmissionsTonnes()));
        result.andExpect(jsonPath("$.pei.[0].totalEmissionsTonnes").value(peiEmitter.getTotalEmissionsTonnes()));
    }
}
