package com.emissions.industrialemissionsmap;

import com.emissions.industrialemissionsmap.model.DataSet;
import com.emissions.industrialemissionsmap.model.Emitter;
import com.emissions.industrialemissionsmap.repository.DataSetRepository;
import com.emissions.industrialemissionsmap.repository.EmitterRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
class DetailsControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    EmitterRepository
    emitterRepository;

    List<Emitter> emitters = new ArrayList<>();

    @BeforeEach
    void setup() {
        emitters.addAll(emitterRepository.findAll());
    }

    @Test
    void detailsControllerTest() throws Exception {
        String testId = emitters.getFirst().getGhgrpId();
        ResultActions result = mockMvc.perform(get("/api/v1/details").param("ghgrpId", testId));
        log.debug(result.andReturn().getResponse().getContentAsString());
        result.andExpect(jsonPath("$.id").value(emitters.getFirst().getId()));
        result.andExpect(jsonPath("$.facilityName").value(emitters.getFirst().getFacilityName()));
        result.andExpect(jsonPath("$.facilityLocation").value(emitters.getFirst().getFacilityLocation()));
        result.andExpect(jsonPath("$.facilityCityOrDistrict").value(emitters.getFirst().getFacilityCityOrDistrict()));
        result.andExpect(jsonPath("$.facilityProvinceTerritory").value(emitters.getFirst().getFacilityProvinceTerritory()));
        result.andExpect(jsonPath("$.facilityPostalCode").value(emitters.getFirst().getFacilityPostalCode()));
        result.andExpect(jsonPath("$.latitude").value(emitters.getFirst().getLatitude()));
        result.andExpect(jsonPath("$.longitude").value(emitters.getFirst().getLongitude()));
        result.andExpect(jsonPath("$.facilityDescription").value(emitters.getFirst().getFacilityDescriptionEnglish()));
        result.andExpect(jsonPath("$.companyLegalName").value(emitters.getFirst().getReportingCompanyLegalName()));
        result.andExpect(jsonPath("$.companyTradeName").value(emitters.getFirst().getReportingCompanyTradeName()));
        result.andExpect(jsonPath("$.businessNumber").value(emitters.getFirst().getReportingCompanyBusinessNumber()));
        result.andExpect(jsonPath("$.publicContactName").value(emitters.getFirst().getPublicContactName()));
        result.andExpect(jsonPath("$.publicContactPosition").value(emitters.getFirst().getPublicContactPosition()));
        result.andExpect(jsonPath("$.publicContactTelephone").value(emitters.getFirst().getPublicContactTelephone()));
        result.andExpect(jsonPath("$.publicContactExtension").value(emitters.getFirst().getPublicContactExtension()));
        result.andExpect(jsonPath("$.publicContactEmail").value(emitters.getFirst().getPublicContactEmail()));
        result.andExpect(jsonPath("$.publicContactMailingAddress").value(emitters.getFirst().getPublicContactMailingAddress()));
        result.andExpect(jsonPath("$.publicContactCityOrDistrict").value(emitters.getFirst().getPublicContactCityOrDistrict()));
        result.andExpect(jsonPath("$.publicContactPostalCode").value(emitters.getFirst().getPublicContactPostalCode()));
        result.andExpect(status().isOk());
    }
}
