package com.emissions.industrialemissionsmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class IndustrialEmissionsMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndustrialEmissionsMapApplication.class, args);
    }

}
