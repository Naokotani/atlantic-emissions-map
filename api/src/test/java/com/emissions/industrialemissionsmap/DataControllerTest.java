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
class DataControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    DataSetRepository dataSetRepository;

    List<DataSet> dataSets = new ArrayList<>();

    @BeforeEach
    void setup() {
        dataSets = dataSetRepository.findAll();
    }

    @Test
    void dataControllerTest() throws Exception {
        ResultActions result = mockMvc.perform(get("/api/v1/data"));
        String expectedTimestamp = dataSets.getFirst().getUploaded().truncatedTo(ChronoUnit.MICROS).toString();
        log.debug(expectedTimestamp);
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.[0].id").value(dataSets.getFirst().getDataSetId()));
        result.andExpect(jsonPath("$.[0].currentYear").value(dataSets.getFirst().getCurrentYear()));
        result.andExpect(jsonPath("$.[0].records").value(dataSets.getFirst().getRecords()));
        result.andExpect(jsonPath("$.[0].uploaded", startsWith(
                dataSets.getFirst().getUploaded().toString().substring(0, 23))));
        result.andExpect(jsonPath("$.[0].years", hasSize(dataSets.getFirst().getYears().size())));
        log.debug(result.andReturn().getResponse().getContentAsString());
    }
}
