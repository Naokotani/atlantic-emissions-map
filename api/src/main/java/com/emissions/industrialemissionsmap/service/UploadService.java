package com.emissions.industrialemissionsmap.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {
    Integer uploadGhgData(MultipartFile file) throws IOException;
}
