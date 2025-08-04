package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.dto.DataSetDto;
import com.emissions.industrialemissionsmap.service.DataSetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/fantastic-friends/dashboard")
public class DashboardController {
    final DataSetService dataSetService;

    public DashboardController(DataSetService dataSetService) {
        this.dataSetService = dataSetService;
    }

    @GetMapping
    public String datasetDashboard(Model model) {
        String view = "datasetDashboard";
        List<DataSetDto> dataSets = dataSetService.findAllDataSets();
        dataSets.forEach(d -> d.setYears(d.getYears().stream().sorted().toList()));
        if (dataSets.isEmpty()) {
            log.error("No datasets found");
            view = "initialDataSet";
        } else {
            model.addAttribute("datasets", dataSets);
        }
        return view;
    }

    @DeleteMapping("/all")
    public String deleteDatasets() {
        dataSetService.deleteAllDataSets();
        return "redirect:/fantastic-friends/dashboard";
    }

    @DeleteMapping()
    public String deleteDataSetById(@RequestParam long id) throws ResponseStatusException {
        dataSetService.deleteDataSetById(id);
        return "redirect:/fantastic-friends/dashboard";
    }

    @PutMapping
    public String setActiveDataSet(@RequestParam long id) throws ResponseStatusException {
        dataSetService.setActiveDataSet(id);
        return "redirect:/fantastic-friends/dashboard";
    }
}
