package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.dto.DataSetDto;
import com.emissions.industrialemissionsmap.service.DataSetService;
import com.emissions.industrialemissionsmap.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/fantastic-friends/dashboard")
public class DashboardController {
    final DataSetService dataSetService;
    final UploadService uploadService;

    public DashboardController(DataSetService dataSetService, UploadService uploadService) {
        this.dataSetService = dataSetService;
        this.uploadService = uploadService;
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

    @PostMapping(consumes = {"multipart/form-data"})
    public String uploadGhgData(
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        uploadService.uploadGhgData(file);
        return "redirect:/fantastic-friends/dashboard";
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
